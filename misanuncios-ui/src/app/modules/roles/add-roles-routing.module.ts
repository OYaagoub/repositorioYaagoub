import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddRolesComponent } from './components/add-roles/add-roles.component';
import { ListRolesComponent } from './components/list-roles/list-roles.component';

const routes: Routes = [
  {
    path: 'add',
    component: AddRolesComponent, // Replace 'YourComponent' with the actual component name
  },
  {
    path: 'list',
    component: ListRolesComponent, // Replace 'YourComponent' with the actual component name
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AddRolesRoutingModule { }
