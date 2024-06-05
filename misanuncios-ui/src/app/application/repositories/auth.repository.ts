import { Observable } from "rxjs";
import { User } from "../../domain/model/user.model";




export abstract class AuthRepository {

  abstract login(user:User): Observable<any>;
  abstract register(user:User): Observable<any>;



}
