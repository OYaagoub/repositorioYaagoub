import { Observable } from "rxjs";
import { Role } from "../../domain/model/role.model";
import { User } from "../../domain/model/user.model";
import { LoginResponse } from "../../infrastructure/dto/loginResponse.dto";
import { UserDto } from "../../infrastructure/dto/user.dto";



export abstract class AuthRepository {

  abstract login(user:User): Observable<any>;
  abstract register(user:User): Observable<any>;



}
