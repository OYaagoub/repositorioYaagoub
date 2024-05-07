import { Category } from "./category.model";
import { Conversation } from "./conversation.model";
import { Image } from "./image.model";

import { User } from "./user.model";

export class  Product {

  id!: number;
  title!: string;
  description!: string;
  user!: User; // Assuming User model exists
  conversations: Set<Conversation> = new Set(); // Assuming Conversation model exists
  images: Set<Image> = new Set(); // Assuming Image model exists
  category!:Category;

  constructor(data:Partial<Product>){
    Object.assign(this, data);
  }
}
