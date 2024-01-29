import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PiattiComponent } from './piatti.component';

describe('PiattiComponent', () => {
  let component: PiattiComponent;
  let fixture: ComponentFixture<PiattiComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PiattiComponent]
    });
    fixture = TestBed.createComponent(PiattiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
