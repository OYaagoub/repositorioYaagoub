import { PermissionDto } from "./permission.dto";
import { RoleDto } from "./role.dto";
import { RoleHasPermissionKeyDto } from "./roleHasPermissionKey.dto";

export interface RoleHasPermissionDto {

  id: RoleHasPermissionKeyDto;
  role: RoleDto; // Assuming Role model exists
  permission: PermissionDto; // Assuming Permission model exists

}
