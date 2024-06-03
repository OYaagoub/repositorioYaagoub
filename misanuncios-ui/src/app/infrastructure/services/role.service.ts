import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, map } from 'rxjs';
import { Role } from '../../domain/model/role.model';
import { RoleMapper } from '../mappers/role.mapper';
import { RoleDto } from '../dto/role.dto';
import { config } from '../config/config';

@Injectable({
 providedIn: 'root',
})
export class RoleService {


 constructor(private http: HttpClient) {}

 getRolesByUser(): Observable<Role[]> {
   return this.http
     .get<RoleDto[]>(`${config["authUrl"]}/roles`)
     .pipe(map((role) => {
      return role.map(RoleMapper.toDomain)
     }));
 }

 addRole(role: Role): Observable<Role> {
   const dto = RoleMapper.toDto(role);
   return this.http
     .post<RoleDto>(config["authUrl"], dto)
     .pipe(map(RoleMapper.toDomain));
 }
 getRole(id: number): Observable<Role> {
   const url = `${config["authUrl"]}/${id}`;
   return this.http
     .get<RoleDto>(url)
     .pipe(map(RoleMapper.toDomain));
 }
 updateRole(role: Role): Observable<Role> {
   const url = `${config["authUrl"]}/${role.id}`;
   const dto = RoleMapper.toDto(role);
   return this.http.put<Role>(url, dto)
      .pipe(map(RoleMapper.toDomain));
 }

 deleteRole(id: number): Observable<Role> {
   const url = `${config["authUrl"]}/${id}`;
   return this.http.delete<Role>(url)
      .pipe(map(RoleMapper.toDomain));
 }
}
