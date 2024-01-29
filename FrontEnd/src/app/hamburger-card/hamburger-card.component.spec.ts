import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HamburgerCardComponent } from './hamburger-card.component';

describe('HamburgerCardComponent', () => {
  let component: HamburgerCardComponent;
  let fixture: ComponentFixture<HamburgerCardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HamburgerCardComponent]
    });
    fixture = TestBed.createComponent(HamburgerCardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
