import { ComponentFixture, TestBed } from '@angular/core/testing';

import { JogoAnimalComponent } from './jogo-animal.component';

describe('JogoAnimalComponent', () => {
  let component: JogoAnimalComponent;
  let fixture: ComponentFixture<JogoAnimalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ JogoAnimalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(JogoAnimalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
