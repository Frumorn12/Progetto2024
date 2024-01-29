import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrenotazionetavoloComponent } from './prenotazionetavolo.component';

describe('PrenotazionetavoloComponent', () => {
  let component: PrenotazionetavoloComponent;
  let fixture: ComponentFixture<PrenotazionetavoloComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrenotazionetavoloComponent]
    });
    fixture = TestBed.createComponent(PrenotazionetavoloComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
