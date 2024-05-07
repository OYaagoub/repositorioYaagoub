import { User } from "./user.model";

export class Notification {

  id!: number;
  message!: string;
  user!: User; // Assuming User model exists
  constructor(data:Partial<Notification>){
    Object.assign(this, data);
  }
}
