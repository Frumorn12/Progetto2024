import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PiattiVetrinaComponent } from './piatti-vetrina.component';

describe('PiattiVetrinaComponent', () => {
  let component: PiattiVetrinaComponent;
  let fixture: ComponentFixture<PiattiVetrinaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PiattiVetrinaComponent]
    });
    fixture = TestBed.createComponent(PiattiVetrinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
