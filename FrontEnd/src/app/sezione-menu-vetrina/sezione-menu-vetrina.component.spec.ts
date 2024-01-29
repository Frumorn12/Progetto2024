import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SezioneMenuVetrinaComponent } from './sezione-menu-vetrina.component';

describe('SezioneMenuVetrinaComponent', () => {
  let component: SezioneMenuVetrinaComponent;
  let fixture: ComponentFixture<SezioneMenuVetrinaComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SezioneMenuVetrinaComponent]
    });
    fixture = TestBed.createComponent(SezioneMenuVetrinaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
