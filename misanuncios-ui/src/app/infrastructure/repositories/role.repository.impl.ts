import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { RoleRepository } from '../../application/repositories/role.repository';
import { Role } from '../../domain/model/role.model';
import { RoleService } from '../services/role.service';


@Injectable({
 providedIn: 'root',
})
export class RoleRepositoryImpl implements RoleRepository {


 constructor(private roleService: RoleService) {}

 getRolesByUser(): Observable<Role[]> {
    return this.roleService.getRolesByUser(); //.pipe(map(res => res.map(role => new Role(role))));
  }
  getRole(id: number): Observable<Role> {
    return this.roleService.getRole(id);
  }
  addRole(role: Role): Observable<Role> {
    return this.roleService.addRole(role);
  }
  updateRole(role: Role): Observable<Role> {
    return this.roleService.updateRole(role);
  }
  deleteRole(id: number): Observable<Role> {
    return this.roleService.deleteRole(id);
  }


}
