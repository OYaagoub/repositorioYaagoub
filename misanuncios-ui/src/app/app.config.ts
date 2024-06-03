import { ApplicationConfig, importProvidersFrom } from '@angular/core';
import { provideRouter } from '@angular/router';

import { routes } from './app.routes';
import { provideClientHydration } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS, provideHttpClient, withFetch, withInterceptors } from '@angular/common/http';
import { Interceptor } from './infrastructure/adapters/interceptor.interceptor';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { provideToastr } from 'ngx-toastr';






export const appConfig: ApplicationConfig = {
  providers: [provideRouter(routes), provideClientHydration(),provideHttpClient(withFetch(), withInterceptors([Interceptor])),
  importProvidersFrom([BrowserAnimationsModule]),provideToastr()
  ],

  //{ provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true }
};
