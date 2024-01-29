import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CreapiattoComponent } from './creapiatto.component';

describe('CreapiattoComponent', () => {
  let component: CreapiattoComponent;
  let fixture: ComponentFixture<CreapiattoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CreapiattoComponent]
    });
    fixture = TestBed.createComponent(CreapiattoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
