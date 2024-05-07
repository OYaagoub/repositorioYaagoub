import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { Observable, map } from 'rxjs';
import { Role } from '../../domain/model/role.model';
import { RoleMapper } from '../../domain/mappers/role.mapper';
import { RoleDto } from '../dto/role.dto';

@Injectable({
 providedIn: 'root',
})
export class RoleService {
 private apiUrl = 'http://localhost:3000/roles';

 constructor(private http: HttpClient) {}

 getRoles(): Observable<Role[]> {
   return this.http
     .get<RoleDto[]>(this.apiUrl)
     .pipe(map((apiTasks) => apiTasks.map(RoleMapper.toDomain)));
 }

 addRole(role: Role): Observable<Role> {
   const dto = RoleMapper.toDto(role);
   return this.http
     .post<RoleDto>(this.apiUrl, dto)
     .pipe(map(RoleMapper.toDomain));
 }
 getRole(id: number): Observable<Role> {
   const url = `${this.apiUrl}/${id}`;
   return this.http
     .get<RoleDto>(url)
     .pipe(map(RoleMapper.toDomain));
 }
 updateRole(role: Role): Observable<Role> {
   const url = `${this.apiUrl}/${role.id}`;
   const dto = RoleMapper.toDto(role);
   return this.http.put<Role>(url, dto)
      .pipe(map(RoleMapper.toDomain));
 }

 deleteRole(id: number): Observable<Role> {
   const url = `${this.apiUrl}/${id}`;
   return this.http.delete<Role>(url)
      .pipe(map(RoleMapper.toDomain));
 }
}
