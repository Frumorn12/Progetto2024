import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabellaOrdiniComponent } from './tabella-ordini.component';

describe('TabellaOrdiniComponent', () => {
  let component: TabellaOrdiniComponent;
  let fixture: ComponentFixture<TabellaOrdiniComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TabellaOrdiniComponent]
    });
    fixture = TestBed.createComponent(TabellaOrdiniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
