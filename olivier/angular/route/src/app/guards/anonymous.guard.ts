import { inject } from '@angular/core';
import { CanActivateFn, Router, UrlTree } from '@angular/router';

export const anonymousGuard: CanActivateFn = (route, state) => {
  return localStorage.getItem('token') == null;
};
