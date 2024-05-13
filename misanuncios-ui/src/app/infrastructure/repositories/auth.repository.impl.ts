import { Injectable } from '@angular/core';
import { AuthRepository } from '../../domain/repositories/auth.repository';
import { User } from '../../domain/model/user.model';
import { AuthService } from '../services/auth.service';
import { UserMapper } from '../../domain/mappers/user.mapper';
import { Observable } from 'rxjs';
import { LoginResponse } from '../dto/loginResponse.dto';
import { UserDto } from '../dto/user.dto';

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
