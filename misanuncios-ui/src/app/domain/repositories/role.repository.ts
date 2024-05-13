import { Observable } from "rxjs";
import { Role } from "../model/role.model";
import { RoleDto } from "../../infrastructure/dto/role.dto";



export abstract class RoleRepository {

  abstract getRolesByUser(): Observable<Role[]>;
  abstract getRole(id: number): Observable<Role>;
  abstract addRole(role: Role): Observable<Role>;
  abstract updateRole(role: Role): Observable<Role>;
  abstract deleteRole(id: number): Observable<Role>;


}
