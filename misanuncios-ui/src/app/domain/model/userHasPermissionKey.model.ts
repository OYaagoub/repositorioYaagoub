export class UserHasPermissionKey {
  userId!: number;
  permissionId!: number;


  constructor(data:Partial<UserHasPermissionKey>){
    Object.assign(this, data);
  }
}
