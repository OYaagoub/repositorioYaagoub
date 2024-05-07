import { PermissionDto } from "./permission.dto";
import { UserDto } from "./user.dto";
import { UserHasPermissionKeyDto } from "./userHasPermissionKey.dto";

export interface UserHasPermissionDto {

  id: UserHasPermissionKeyDto;
  user: UserDto; // Assuming User model exists
  permission: PermissionDto; // Assuming Permission model exists


}
