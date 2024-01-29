import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DolciComponent } from './dolci.component';

describe('DolciComponent', () => {
  let component: DolciComponent;
  let fixture: ComponentFixture<DolciComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DolciComponent]
    });
    fixture = TestBed.createComponent(DolciComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
