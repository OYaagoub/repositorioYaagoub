import { Observable } from "rxjs";
import { Role } from "../../domain/model/role.model";
import { User } from "../../domain/model/user.model";
import { UserDto } from "../../infrastructure/dto/user.dto";



export abstract class UserRepository {

  abstract getUser(): Observable<User | null>;



}
