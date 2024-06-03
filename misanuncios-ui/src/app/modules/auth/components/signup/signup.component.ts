import { Component } from '@angular/core';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { NgxSpinnerService } from 'ngx-spinner';
import { AuthRepository } from '../../../../application/repositories/auth.repository';
import { AuthRepositoryImpl } from '../../../../infrastructure/repositories/auth.repository.impl';
import { Router } from '@angular/router';
import { AlertsService } from '../../../../infrastructure/services/alerts.service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss',
  providers:[{provide: AuthRepository, useClass: AuthRepositoryImpl}]
})
export class SignupComponent {

  constructor(private alerts:AlertsService,private spinner: NgxSpinnerService,private formBuilder: FormBuilder,private authRepository: AuthRepository,private router: Router) {}
  registerForm!: FormGroup;


  ngOnInit(): void {
    this.spinner.show();
    setTimeout(() => {
      /** spinner ends after 5 seconds */
      this.spinner.hide();
    }, 1000);
    this.registerForm = this.formBuilder.group({
      password: ['',[Validators.min(3),Validators.required]],
      email: ['', [Validators.required, Validators.email]],
      confirmPassword:['',[Validators.min(3),Validators.required]]
    });
  }
  register() {
    if (this.registerForm?.valid && this.registerForm?.value.password === this.registerForm?.value.confirmPassword) {
      // Perform login logic here
      this.spinner.show();
      const user = this.registerForm.value;

      this.authRepository.register(user)
        .subscribe(
          (response) => {
            this.spinner.hide();
            this.alerts.showSuccess("Usuario registrado con exito")
            // Login successful, redirect to home or dashboard
            this.router.navigateByUrl('/auth/login');
          },
          (error) => {
            console.error("Error during login:", error);
            this.spinner.hide();
            this.alerts.showDanger("Error al registrar el usuario")
            // Handle error: display error message to the user, etc.
          }
        );
    }else{
      this.alerts.showDanger("Las contraseñas no coinciden o no cumplen con los requisitos")
    }
  }


}
