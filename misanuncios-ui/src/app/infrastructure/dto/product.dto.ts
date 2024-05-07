import { CategoryDto } from "./category.dto";
import { ConversationDto } from "./conversation.dto";
import { ImageDto } from "./image.dto";
import { UserDto } from "./user.dto";

export interface  ProductDto {

  id: number;
  title: string;
  description: string;
  user: UserDto; // Assuming User model exists
  conversations: Set<ConversationDto>; // Assuming Conversation model exists
  images: Set<ImageDto> ; // Assuming Image model exists
  category:CategoryDto;


}
