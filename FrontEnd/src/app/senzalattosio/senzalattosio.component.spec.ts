import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SenzalattosioComponent } from './senzalattosio.component';

describe('SenzalattosioComponent', () => {
  let component: SenzalattosioComponent;
  let fixture: ComponentFixture<SenzalattosioComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SenzalattosioComponent]
    });
    fixture = TestBed.createComponent(SenzalattosioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
