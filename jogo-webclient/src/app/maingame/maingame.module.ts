import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { MaingameRoutingModule } from './maingame-routing.module';
import { JogoAnimalComponent } from './jogo-animal/jogo-animal.component';
import {MatCardModule} from '@angular/material/card';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatButtonModule} from '@angular/material/button'; 
import {MatInputModule} from '@angular/material/input'; 


@NgModule({
  declarations: [
    JogoAnimalComponent,
  ],
  imports: [
    CommonModule,
    MaingameRoutingModule,
    MatGridListModule,
    MatCardModule,
    MatButtonModule,
    MatInputModule
  ]
})
export class MaingameModule { }
