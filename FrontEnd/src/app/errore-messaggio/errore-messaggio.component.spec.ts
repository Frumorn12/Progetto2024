import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ErroreMessaggioComponent } from './errore-messaggio.component';

describe('ErroreMessaggioComponent', () => {
  let component: ErroreMessaggioComponent;
  let fixture: ComponentFixture<ErroreMessaggioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ErroreMessaggioComponent]
    });
    fixture = TestBed.createComponent(ErroreMessaggioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
