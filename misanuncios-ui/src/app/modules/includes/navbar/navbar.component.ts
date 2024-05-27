import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../../infrastructure/services/auth.service';
import { NewComponent } from '../../products/components/crud/new/new.component';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [RouterLink,NewComponent],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.scss'
})
export class NavbarComponent {
    isOpen:boolean = false;
    isLoggedIn: boolean = false;
    constructor(private authService: AuthService,private router:Router) {
      console.log(this.isLoggedIn)
      authService.userIsLoggedIn.subscribe(isLoggedIn => {
        this.isLoggedIn = isLoggedIn;
      })
      console.log(this.isLoggedIn)
     }
     // logout function
     logout() {
       this.authService.logout();
       this.isLoggedIn= false;
       this.router.navigate(["/"])

     }
     open(){
      this.isOpen=this.isOpen?false:true;
     }
}
