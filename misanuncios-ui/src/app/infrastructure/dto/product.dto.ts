
import { CategoryDto } from "./category.dto";
import { ConversationDto } from "./conversation.dto";
import { ImageDto } from "./image.dto";
import { UserDto } from "./user.dto";

export interface  ProductDto {

  id: number;
  title: string;
  description: string;
  price:string;
  user: UserDto | null; // Assuming User model exists
  //conversations: ConversationDto[]; // Assuming Conversation model exists
  images: ImageDto[] | null; // Assuming Image model exists
  category:CategoryDto | null;


}
