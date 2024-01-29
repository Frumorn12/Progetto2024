import { TestBed } from '@angular/core/testing';

import { PiattiServiceService } from './piatti-service.service';

describe('PiattiServiceService', () => {
  let service: PiattiServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PiattiServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
