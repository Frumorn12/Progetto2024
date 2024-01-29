import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContorniComponent } from './contorni.component';

describe('ContorniComponent', () => {
  let component: ContorniComponent;
  let fixture: ComponentFixture<ContorniComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ContorniComponent]
    });
    fixture = TestBed.createComponent(ContorniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
