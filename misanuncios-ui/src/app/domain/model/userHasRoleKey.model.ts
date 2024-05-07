export class UserHasRoleKey {
  userId!: number;
  roleId!: number;


  constructor(data:Partial<UserHasRoleKey>){
    Object.assign(this, data);
  }
}
