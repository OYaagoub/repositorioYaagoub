import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { RoleRepository } from '../../application/repositories/role.repository';
import { Role } from '../../domain/model/role.model';
import { RoleService } from '../services/role.service';
import { UserRepository } from '../../application/repositories/user.repository';
import { User } from '../../domain/model/user.model';
import { UserService } from '../services/user.service';
import { UserDto } from '../dto/user.dto';

@Injectable({
 providedIn: 'root',
})
export class UserRepositoryImpl implements UserRepository {

 constructor(private userService: UserService) {}
  getUser(): Observable<User | null> {
    return this.userService.getUser();
  }



}
