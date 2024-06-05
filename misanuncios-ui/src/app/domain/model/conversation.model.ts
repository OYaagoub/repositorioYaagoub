import { Product } from "./product.model";
import { User } from "./user.model";

export class Conversation {
  id!: number;
  sender!: User; // Assuming User model exists
  product!: Product; // Assuming Product model exists
  //messages!: Message[]; // Assuming Message model exists

  constructor(data:Partial<Conversation>){
    Object.assign(this, data);
  }
}
