import { Permission } from "./permission.model";
import { Role } from "./role.model";
import { RoleHasPermissionKey } from "./roleHasPermissionKey.model";

export class RoleHasPermission {

  id!: RoleHasPermissionKey;
  role!: Role; // Assuming Role model exists
  permission!: Permission; // Assuming Permission model exists

  constructor(data:Partial<RoleHasPermission>){
    Object.assign(this, data);
  }
}
