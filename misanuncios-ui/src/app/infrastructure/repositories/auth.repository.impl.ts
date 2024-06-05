import { Injectable } from '@angular/core';
import { AuthRepository } from '../../application/repositories/auth.repository';
import { User } from '../../domain/model/user.model';
import { AuthService } from '../services/auth.service';
import { Observable } from 'rxjs';

@Injectable({
 providedIn: 'root',
})
export class AuthRepositoryImpl implements AuthRepository {


 constructor(private authService: AuthService) {}
  login(user: User): Observable<any> {
    return this.authService.login(user);
  }
  register(user: User): Observable<any> {
    return this.authService.register(user);
  }





}
