import { TestBed } from '@angular/core/testing';

import { PrenotazioneServiceService } from './prenotazione-service.service';

describe('PrenotazioneServiceService', () => {
  let service: PrenotazioneServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PrenotazioneServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
