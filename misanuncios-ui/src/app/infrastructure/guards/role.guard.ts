import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { Observable, catchError, map, of } from 'rxjs';
import { AuthService } from '../services/auth.service';
import { error } from 'console';


@Injectable({
  providedIn: 'root'
})
export class RoleGuard implements CanActivate {

  constructor(private authService: AuthService, private router: Router) {}

  canActivate(
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean> | Promise<boolean> | boolean {

    // Check if the user is authenticated
    if (!this.authService.isAuthenticated()) {
      // Redirect the user to the login page if not authenticated
      this.router.navigate(['/auth/login']);
      return false;
    }
    // Check if the user has the required role
    const roles = next.data['roles'] as Array<string>;
    return this.authService.hasRole(roles).pipe(
      map(hasRole => {
        if (!hasRole) {
          // Redirect the user to a forbidden page if they don't have the required role
          this.router.navigate(['/forbidden']);
        }
        return hasRole;
      }),
      catchError(error => {
        // Handle errors if any
        console.error('Error checking role:', error);
        return of(false); // Return false to deny access
      })
    );
  }

}
