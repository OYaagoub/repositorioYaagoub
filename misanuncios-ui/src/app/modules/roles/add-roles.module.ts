import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { AddRolesRoutingModule } from './add-roles-routing.module';
import { RoleRepositoryImpl } from '../../infrastructure/repositories/role.repository.impl';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    AddRolesRoutingModule
  ],
  //providers: [RoleRepositoryImpl]


})
export class AddRolesModule { }
