import { RoleHasPermission } from "./roleHasPermission.model";
import { UserHasPermission } from "./userHasPermission.model";

export class Permission {

  id!: number;
  name!: string;
  users: Set<UserHasPermission> = new Set(); // Assuming UserHasPermission model exists
  roles: Set<RoleHasPermission> = new Set(); // Assuming RoleHasPermission model exists


  constructor(data:Partial<Permission>){
    Object.assign(this, data);
  }
}
