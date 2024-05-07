import { Role } from "./role.model";
import { User } from "./user.model";
import { UserHasRoleKey } from "./userHasRoleKey.model";

export class UserHasRole
{
  id!: UserHasRoleKey;
  role!: Role; // Assuming Role model exists
  user!: User; // Assuming User model exists
  constructor(data:Partial<UserHasRole>){
    Object.assign(this, data);
  }
}
