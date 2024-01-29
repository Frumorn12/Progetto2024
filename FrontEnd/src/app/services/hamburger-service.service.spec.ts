import { TestBed } from '@angular/core/testing';

import { HamburgerServiceService } from './hamburger-service.service';

describe('HamburgerServiceService', () => {
  let service: HamburgerServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HamburgerServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
