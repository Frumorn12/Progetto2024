import { TestBed } from '@angular/core/testing';

import { AuthGuardAdminServiceService } from './auth-guard-admin-service.service';

describe('AuthGuardAdminServiceService', () => {
  let service: AuthGuardAdminServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthGuardAdminServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
