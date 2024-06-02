import { Component } from '@angular/core';
import { AuthRepository } from '../../../../application/repositories/auth.repository';
import { AuthRepositoryImpl } from '../../../../infrastructure/repositories/auth.repository.impl';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { AlertsService } from '../../../../infrastructure/services/alerts.service';


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

  constructor(private alerts:AlertsService,private spinner: NgxSpinnerService,private formBuilder: FormBuilder,private authRepository: AuthRepository,private router: Router) {}

  ngOnInit(): void {
    this.spinner.show();
    setTimeout(() => {
      /** spinner ends after 5 seconds */
      this.spinner.hide();
    }, 2000);
    this.loginForm = this.formBuilder.group({
      password: ['',[Validators.min(3),Validators.required]],
      email: ['', [Validators.required, Validators.email]],
    });
  }
  login() {
    if (this.loginForm?.valid) {
      // Perform login logic here
      this.spinner.show();
      const user = this.loginForm.value;

      this.authRepository.login(user)
        .subscribe(
          (response) => {
            this.spinner.hide();
            this.alerts.showSuccess("Logiado exitoso")
            // Login successful, redirect to home or dashboard
            this.router.navigateByUrl('/');
          },
          (error) => {
            console.error("Error during login:", error);
            this.spinner.hide();
            this.alerts.showDanger("Error al iniciar sesión")
            // Handle error: display error message to the user, etc.
          }
        );
    }
  }


}
