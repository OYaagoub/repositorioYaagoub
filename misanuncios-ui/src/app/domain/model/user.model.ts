import { Conversation } from "./conversation.model";
import { Notification } from "./notification.model";

import { Product } from "./product.model";
import { UserHasPermission } from "./userHasPermission.model";
import { UserHasRole } from "./userHasRole.model";

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
