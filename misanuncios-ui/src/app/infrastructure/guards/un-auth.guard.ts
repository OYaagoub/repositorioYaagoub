import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../services/user.service';
import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class unAuthGuard implements CanActivate {
  isAuthenticated!:boolean;
  // inject the router service to allow navigation.
  constructor(private router: Router, private userService: UserService,private authService: AuthService) { }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    // get the user from the service.
    this.userService.getUser().subscribe(user => {
      // if the user is not logged in, redirect to the login page.
      if (!user) {
        this.isAuthenticated=true;
      } else {
        //this.authService.logout();
        this.router.navigateByUrl('/');
        this.isAuthenticated=false;
      }
    })
    return this.isAuthenticated;

  }

}
