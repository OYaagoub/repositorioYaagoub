import { HttpInterceptorFn } from '@angular/common/http';
import { AuthService } from '../services/auth.service';
import { inject } from '@angular/core';





export const Interceptor: HttpInterceptorFn = (req, next) => {
  // Create an instance of InterceptorService
  const authService = inject(AuthService);
  const authToken =authService.userToken;
  if (authToken != "") {
    // Clone the request and add the authorization header
    const authReq = req.clone({
      setHeaders: {
        Authorization: `Bearer ${authToken==null ? '' : authToken}`
      }
    });
    return next(authReq);
  }
  return next(req);
  // Pass the cloned request with the updated header to the next handler
};
