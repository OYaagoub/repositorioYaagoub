export class User {

  id!: number;
  name!: string;
  image!: string | null;
  email!: string;
  birth!: Date | null;
  password!: string | null;
  remember_token!: string | null;
  email_verified_at!: Date | null;
  //roles!: UserHasRole[]; // Assuming UserHasRole model exists
  //permissions!: UserHasPermission[]; // Assuming UserHasPermission model exists



  constructor(data:Partial<User>){
    Object.assign(this, data);
  }
}
