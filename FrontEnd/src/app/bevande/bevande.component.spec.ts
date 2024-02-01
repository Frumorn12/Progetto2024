import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BevandeComponent } from './bevande.component';
// Dichiarazione delle variabili necessarie per i test
describe('BevandeComponent', () => {
  let component: BevandeComponent;
  let fixture: ComponentFixture<BevandeComponent>;
// Blocco che viene eseguito prima di ogni test
  beforeEach(() => {
    // Configurazione del modulo di testing di Angular
    TestBed.configureTestingModule({
      declarations: [BevandeComponent] // Dichiarazione del componente da testare
    });
    // Creazione di un'istanza del componente utilizzando TestBed
    fixture = TestBed.createComponent(BevandeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });
// Singolo test che verifica se il componente può essere creato correttamente
  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
