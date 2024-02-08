import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KendoDatepickerComponent } from './kendo-datepicker.component';

describe('KendoDatepickerComponent', () => {
  let component: KendoDatepickerComponent;
  let fixture: ComponentFixture<KendoDatepickerComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [KendoDatepickerComponent]
    });
    fixture = TestBed.createComponent(KendoDatepickerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
