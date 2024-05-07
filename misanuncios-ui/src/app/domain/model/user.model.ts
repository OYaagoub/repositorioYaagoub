import { Conversation } from "./conversation.model";
import { UserHasRole } from "./UserHasRole.model";
import { Product } from "./product.model";
import { UserHasPermission } from "./userHasPermission.model";

export class User {

  id!: number;
  name!: string;
  image!: string | null;
  email!: string;
  birth!: Date | null;
  password!: string;
  remember_token!: string | null;
  email_verified_at!: Date | null;
  products: Set<Product> = new Set(); // Assuming Product model exists
  notifications: Set<Notification> = new Set(); // Assuming Notification model exists
  roles: Set<UserHasRole> = new Set(); // Assuming UserHasRole model exists
  permissions: Set<UserHasPermission> = new Set(); // Assuming UserHasPermission model exists
  conversations: Set<Conversation> = new Set(); // Assuming Conversation model exists


  constructor(data:Partial<User>){
    Object.assign(this, data);
  }
}
