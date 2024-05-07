import { RoleHasPermissionDto } from "./roleHasPermission.dto";
import { UserHasPermissionDto } from "./userHasPermission.dto";

export interface PermissionDto {

  id: number;
  name: string;
  users: Set<UserHasPermissionDto> ; // Assuming UserHasPermission model exists
  roles: Set<RoleHasPermissionDto> ; // Assuming RoleHasPermission model exists



}
