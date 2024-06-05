import { ProductDto } from "./product.dto";
import { UserDto } from "./user.dto";

export interface ConversationDto {
  id: number;
  sender: UserDto; // Assuming User model exists
  product: ProductDto; // Assuming Product model exists
  //messages: MessageDto[]; // Assuming Message model exists

}
