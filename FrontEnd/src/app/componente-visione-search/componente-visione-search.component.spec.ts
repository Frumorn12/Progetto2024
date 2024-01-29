import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ComponenteVisioneSearchComponent } from './componente-visione-search.component';

describe('ComponenteVisioneSearchComponent', () => {
  let component: ComponenteVisioneSearchComponent;
  let fixture: ComponentFixture<ComponenteVisioneSearchComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ComponenteVisioneSearchComponent]
    });
    fixture = TestBed.createComponent(ComponenteVisioneSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
