import { Component } from '@angular/core';
import { AuthRepository } from '../../../../domain/repositories/auth.repository';
import { AuthRepositoryImpl } from '../../../../infrastructure/repositories/auth.repository.impl';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss',
  providers:[{provide: AuthRepository, useClass: AuthRepositoryImpl}]
})
export class LoginComponent {
  loginForm!: FormGroup;

  constructor(private formBuilder: FormBuilder,private authRepository: AuthRepository,private router: Router) {}
  ngOnInit(): void {
    this.loginForm = this.formBuilder.group({
      password: ['',[Validators.min(3),Validators.required]],
      email: ['', [Validators.required, Validators.email]],
    });
  }
  login() {
    if (this.loginForm?.valid) {
      const user = this.loginForm.value;

      this.authRepository.login(user)
        .subscribe(
          (response) => {
            this.router.navigateByUrl('/');
          },
          (error) => {
            console.error("Error during login:", error);
            // Handle error: display error message to the user, etc.
          }
        );
    }
  }


}
