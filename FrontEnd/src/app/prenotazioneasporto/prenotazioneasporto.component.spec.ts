import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PrenotazioneasportoComponent } from './prenotazioneasporto.component';

describe('PrenotazioneasportoComponent', () => {
  let component: PrenotazioneasportoComponent;
  let fixture: ComponentFixture<PrenotazioneasportoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [PrenotazioneasportoComponent]
    });
    fixture = TestBed.createComponent(PrenotazioneasportoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
