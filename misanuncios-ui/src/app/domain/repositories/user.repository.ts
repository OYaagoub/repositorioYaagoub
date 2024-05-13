import { Observable } from "rxjs";
import { Role } from "../model/role.model";
import { User } from "../model/user.model";
import { UserDto } from "../../infrastructure/dto/user.dto";



export abstract class UserRepository {

  abstract getUser(): Observable<User>;



}
