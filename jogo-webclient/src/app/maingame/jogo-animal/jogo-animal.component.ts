import { Component, OnInit } from '@angular/core';
import { JogoService } from '../jogo.service';
import { NodeModel, NodeType } from '../node.model';
import { MatDialog } from '@angular/material/dialog';
import { WinDialogComponent } from '../win-dialog/win-dialog.component';

@Component({
  selector: 'app-jogo-animal',
  templateUrl: './jogo-animal.component.html',
  styleUrls: ['./jogo-animal.component.scss']
})
export class JogoAnimalComponent implements OnInit {

  constructor(private jogoService: JogoService, public dialog: MatDialog) { }

  ngOnInit(): void {
  }

  currentNode: NodeModel = new NodeModel();
  parentNode: NodeModel = new NodeModel();
  novaRegra: NodeModel;
  novoAnimal: NodeModel;

  gameStart: boolean = false;
  isCurrentAnimal: boolean = false;
  isRegraEnabled: boolean = false;
  enableInsertAnimal: boolean = false;
  nomeAnimal: string;

  iniciarJogo(): void {

    //Busca o primeiro nó do jogo, a regra na raiz da árvore.
    if(!this.gameStart) {
      this.jogoService.getRootNode().subscribe( res => {
        this.currentNode = res;
      })
    }
    this.gameStart = true;
    this.isCurrentAnimal = false;
  }

  proximoNode(isYes: boolean): void {

    //Se o nó atual for uma regra, busca o próximo caso sim, caso não.
    if(!this.isCurrentAnimal && isYes && !!this.currentNode.yesNode.id) {
      this.parentNode = this.currentNode; //Salva o nó anterior.
      this.jogoService.getNext(this.currentNode.yesNode.id).subscribe(res => {
        this.currentNode = res;
        this.isCurrentAnimal = this.currentNode.type === NodeType.Animal;
      });
    }
    else if(!this.isCurrentAnimal &&!!this.currentNode.noNode.id) {
      this.parentNode = this.currentNode; //Salva o nó anterior.
      this.jogoService.getNext(this.currentNode.noNode.id).subscribe(res => {
        this.currentNode = res;
        this.isCurrentAnimal = this.currentNode.type === NodeType.Animal;
      });
    }
    
    //Se o nó atual for um Animal, decide se deve adicionar mais dados ou encerrar o jogo.
    if(this.isCurrentAnimal && isYes) {
      //victory
      this.dialogVitoria();
    }
    else if(this.isCurrentAnimal){
      this.enableInsertAnimal = true;
    }
  }

  //cria a regra nova para aquele animal e atualiza as referências do nó pai
  addNovaRegra(nomeRegra: string){
    if(!!nomeRegra){
      this.novaRegra = new NodeModel();
      this.novaRegra.type = NodeType.Regra;
      this.novaRegra.description = nomeRegra;
      this.novaRegra.yesNode = this.novoAnimal;
      this.novaRegra.noNode = this.currentNode;
      this.jogoService.createNode(this.novaRegra).subscribe(res => {
        this.novaRegra = res;
      });
      if(this.parentNode.yesNode.id == this.currentNode.id){
        this.parentNode.yesNode = this.novaRegra;
      }
      else{
        this.parentNode.noNode = this.novaRegra;
      }
      this.jogoService.updateNode(this.parentNode).subscribe(res => {
        this.gameStart = !this.gameStart;
        this.isRegraEnabled = !this.isRegraEnabled;
        this.enableInsertAnimal = !this.enableInsertAnimal;
      })
    }
  }

  //cria o animal digitado e habilita os campos para criar a regra nova.
  enableRegra(nomeAnimal: string){
    if(!!nomeAnimal){
      this.novoAnimal = new NodeModel();
      this.novoAnimal.type = NodeType.Animal;
      this.novoAnimal.description = nomeAnimal;
      this.jogoService.createNode(this.novoAnimal).subscribe(res => {
        this.novoAnimal = res;
      })
      this.isRegraEnabled = !this.isRegraEnabled;
    }
  }

  dialogVitoria(): void{
    const dialogRef = this.dialog.open(WinDialogComponent);
    dialogRef.afterClosed().subscribe(() => {
      this.gameStart = !this.gameStart;
    })
  }

}
