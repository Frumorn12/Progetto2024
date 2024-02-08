import { TestBed } from '@angular/core/testing';

import { OrdiniServiceService } from './ordini-service.service';

describe('OrdiniServiceService', () => {
  let service: OrdiniServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(OrdiniServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
