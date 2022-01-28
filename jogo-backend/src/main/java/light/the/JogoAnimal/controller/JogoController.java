package light.the.JogoAnimal.controller;

import light.the.JogoAnimal.domain.Node;
import light.the.JogoAnimal.service.NodeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("game")
@RequiredArgsConstructor
public class JogoController {

    private final NodeService nodeService;

    /**
     * GET: Começa o jogo a partir da raiz da árvore
     * @return Node correspondente à raiz da árvore
     */
    @GetMapping
    public ResponseEntity<Node> getRootNode(){
        return ResponseEntity.ok(nodeService.getRootNode());
    }

    /**
     * GET {id}/yes: Busca o próximo nó usando sim como resposta TODO:refactor
     * @param id ID do nó atual
     * @return Node correspondente ao próximo na árvore
     */
    @GetMapping("{id}")
    public ResponseEntity<Node> getNext(@PathVariable("id") Long id){
        return ResponseEntity.ok(nodeService.findNodeByID(id));
    }

//    /**
//     * GET {id}/no: Busca o próximo nó usando não como resposta
//     * @param id ID do nó atual
//     * @return Node correspondente ao próximo na árvore
//     */
//    @GetMapping("{id}/no")
//    public ResponseEntity<Node> getNextFalse(@PathVariable("id") Long id){
//        return ResponseEntity.ok(nodeService.getNext(id, false));
//    }

    /**
     * POST new: Cria um novo nó
     * @param newNode Objeto contendo os dados do nó a ser criado
     * @return Node criado na base de dados
     */
    @PostMapping("new")
    public ResponseEntity<Node> createNode(@RequestBody Node newNode){
        Node created = nodeService.persistNode(newNode);
        return ResponseEntity.created(URI.create("game")).body(created);
    }

    /**
     * PUT: Edita detalhes de um nó, atualizando as suas referências
     * @param nodeWithNewRefs Nó atualizado com novas referẽncias
     * @return Node atualizado na base de dados.
     */
    @PutMapping("update")
    public ResponseEntity<Node> updateNodeRefs(@RequestBody Node nodeWithNewRefs){
        return ResponseEntity.ok(nodeService.persistNode(nodeWithNewRefs));
    }

}
