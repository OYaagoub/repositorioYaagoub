import { Component } from '@angular/core';
import { Router, RouterLink } from '@angular/router';
import { AuthService } from '../../../infrastructure/services/auth.service';
import { NewComponent } from '../../products/components/crud/new/new.component';
import { UserService } from '../../../infrastructure/services/user.service';
import { User } from '../../../domain/model/user.model';

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
    user!:string | null;
    isHidden:boolean=false;
    constructor(private authService: AuthService,private router:Router,private userService:UserService) {

      authService.userIsLoggedIn.subscribe(isLoggedIn => {
        this.isLoggedIn = isLoggedIn;
        this.OnLoad();
      })


     }

     // logout function
     logout() {
      this.isHidden=false;
       this.authService.logout();
       this.isLoggedIn= false;
       this.router.navigate(["/"])

     }
     open(){
      this.isOpen=this.isOpen?false:true;
     }
     toggleHidden(){
       this.isHidden=this.isHidden?false:true;
     }

     OnLoad(){
      this.authService.getUser.subscribe(user => {
        this.user = user;
        console.log(this.user);
      })
     }
}
