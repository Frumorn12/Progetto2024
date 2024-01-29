import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SezionePiattiVetrinaComponent } from './sezione-piatti-vetrina.component';

describe('SezionePiattiVetrinaComponent', () => {
  let component: SezionePiattiVetrinaComponent;
  let fixture: ComponentFixture<SezionePiattiVetrinaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SezionePiattiVetrinaComponent]
    });
    fixture = TestBed.createComponent(SezionePiattiVetrinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
