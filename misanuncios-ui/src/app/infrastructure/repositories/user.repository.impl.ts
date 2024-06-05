import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserRepository } from '../../application/repositories/user.repository';
import { User } from '../../domain/model/user.model';
import { UserService } from '../services/user.service';

@Injectable({
 providedIn: 'root',
})
export class UserRepositoryImpl implements UserRepository {

 constructor(private userService: UserService) {}
  getUser(): Observable<User | null> {
    return this.userService.getUser();
  }



}
