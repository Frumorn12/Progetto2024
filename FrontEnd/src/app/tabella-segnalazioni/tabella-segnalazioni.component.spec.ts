import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TabellaSegnalazioniComponent } from './tabella-segnalazioni.component';

describe('TabellaSegnalazioniComponent', () => {
  let component: TabellaSegnalazioniComponent;
  let fixture: ComponentFixture<TabellaSegnalazioniComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [TabellaSegnalazioniComponent]
    });
    fixture = TestBed.createComponent(TabellaSegnalazioniComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
