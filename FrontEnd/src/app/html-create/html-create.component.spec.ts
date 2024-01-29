import { ComponentFixture, TestBed } from '@angular/core/testing';

import { HtmlCreateComponent } from './html-create.component';

describe('HtmlCreateComponent', () => {
  let component: HtmlCreateComponent;
  let fixture: ComponentFixture<HtmlCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [HtmlCreateComponent]
    });
    fixture = TestBed.createComponent(HtmlCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
