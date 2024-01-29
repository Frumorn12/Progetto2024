import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SenzaglutineComponent } from './senzaglutine.component';

describe('SenzaglutineComponent', () => {
  let component: SenzaglutineComponent;
  let fixture: ComponentFixture<SenzaglutineComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SenzaglutineComponent]
    });
    fixture = TestBed.createComponent(SenzaglutineComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
