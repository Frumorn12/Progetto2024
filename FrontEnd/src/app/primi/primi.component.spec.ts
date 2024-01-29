import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrimiComponent } from './primi.component';

describe('PrimiComponent', () => {
  let component: PrimiComponent;
  let fixture: ComponentFixture<PrimiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrimiComponent]
    });
    fixture = TestBed.createComponent(PrimiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
