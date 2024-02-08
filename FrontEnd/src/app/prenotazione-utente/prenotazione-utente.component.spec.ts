import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrenotazioneUtenteComponent } from './prenotazione-utente.component';

describe('PrenotazioneUtenteComponent', () => {
  let component: PrenotazioneUtenteComponent;
  let fixture: ComponentFixture<PrenotazioneUtenteComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrenotazioneUtenteComponent]
    });
    fixture = TestBed.createComponent(PrenotazioneUtenteComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
