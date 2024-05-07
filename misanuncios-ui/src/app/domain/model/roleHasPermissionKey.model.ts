export class RoleHasPermissionKey {

  roleId!: number;
  permissionId!: number;

  constructor(data:Partial<RoleHasPermissionKey>){
    Object.assign(this, data);
  }
}
