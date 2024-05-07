import { RoleDto } from "./role.dto";
import { UserDto } from "./user.dto";

import { UserHasRoleKeyDto } from "./userHasRoleKey.dto";

export interface UserHasRoleDto
{
  id: UserHasRoleKeyDto;
  role: RoleDto; // Assuming Role model exists
  user: UserDto; // Assuming User model exists

}
