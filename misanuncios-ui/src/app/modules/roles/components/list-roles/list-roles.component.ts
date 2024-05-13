import { Component, OnInit } from '@angular/core';
import { Role } from '../../../../domain/model/role.model';
import { RoleRepository } from '../../../../domain/repositories/role.repository';
import { RoleRepositoryImpl } from '../../../../infrastructure/repositories/role.repository.impl';

@Component({
  selector: 'app-list-roles',
  standalone: true,
  imports: [],
  templateUrl: './list-roles.component.html',
  styleUrl: './list-roles.component.scss',
  providers: [{provide: RoleRepository, useClass: RoleRepositoryImpl}]


})
export class ListRolesComponent implements OnInit {
  roles!:Role[];
  constructor(private roleRepository: RoleRepository) {
  }
  ngOnInit() {
    this.loadRoles();
  }
  loadRoles(): void {
    this.roleRepository.getRolesByUser().subscribe({
      next: (roles: Role[]) => {
        this.roles = roles;
      },
      error: (error) => {
        console.error('Error al cargar los roles:', error);
      },
    });
  }
}
