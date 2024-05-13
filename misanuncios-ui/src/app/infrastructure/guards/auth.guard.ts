import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Route, Router, RouterStateSnapshot, UrlSegment, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UserService } from '../services/user.service';
import { User } from '../../domain/model/user.model';
import { AuthService } from '../services/auth.service';

// hardcoded user data.
const loggedInUser = {
  id: '1zx-casd123-asdzxc132',
  name: 'Lakindu Hewawasam',
  role: 'customer'
}

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
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
        this.authService.logout();
        this.router.navigateByUrl('/auth/login');
        this.isAuthenticated=false;

      } else {
        this.isAuthenticated=true;


      }
    })

    return this.isAuthenticated;

    // user exists

  }

}
