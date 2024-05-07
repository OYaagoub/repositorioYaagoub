import { Permission } from "./permission.model";
import { User } from "./user.model";
import { UserHasPermissionKey } from "./userHasPermissionKey.model";

export class UserHasPermission {

  id!: UserHasPermissionKey;
  user!: User; // Assuming User model exists
  permission!: Permission; // Assuming Permission model exists

  constructor(data:Partial<UserHasPermission>){
    Object.assign(this, data);
  }
}
