import { Observable } from "rxjs";
import { User } from "../../domain/model/user.model";


export abstract class UserRepository {

  abstract getUser(): Observable<User | null>;



}
