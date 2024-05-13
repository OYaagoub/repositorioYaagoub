import { Category } from "./category.model";
import { Conversation } from "./conversation.model";
import { Image } from "./image.model";

import { User } from "./user.model";

export class  Product {

  id!: number;
  title!: string;
  description!: string;
  price!: string;
  user!: User | null; // Assuming User model exists
  //conversations!: Conversation[]; // Assuming Conversation model exists
  //images!:Image[]; // Assuming Image model exists
  category!:Category | null;

  constructor(data:Partial<Product>){
    Object.assign(this, data);
  }
}
