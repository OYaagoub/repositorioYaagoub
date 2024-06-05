import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, map } from 'rxjs';
import { User } from '../../domain/model/user.model';
import { UserDto } from '../dto/user.dto';
import { UserMapper } from '../mappers/user.mapper';
import { config } from '../config/config';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) { }
  getUser(): Observable<User | null> {
    const url = `${config['authUrl']}/user`;
    return this.http.get<UserDto>(url).pipe(map((userdto)=>{
      if(userdto){
        return UserMapper.toDomain(userdto)
      }else{
        return null
      }
    }));
  }
}
