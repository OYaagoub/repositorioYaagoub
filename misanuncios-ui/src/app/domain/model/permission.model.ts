import { RoleHasPermission } from "./roleHasPermission.model";
import { UserHasPermission } from "./userHasPermission.model";

export class Permission {

  id!: number;
  name!: string;



  constructor(data:Partial<Permission>){
    Object.assign(this, data);
  }
}
