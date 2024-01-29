import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SegnalaciComponent } from './segnalaci.component';

describe('SegnalaciComponent', () => {
  let component: SegnalaciComponent;
  let fixture: ComponentFixture<SegnalaciComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SegnalaciComponent]
    });
    fixture = TestBed.createComponent(SegnalaciComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
