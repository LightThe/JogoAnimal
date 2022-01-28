import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { JogoAnimalComponent } from './jogo-animal/jogo-animal.component';

const routes: Routes = [
  {path: '', component: JogoAnimalComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class MaingameRoutingModule { }
