import { ConversationDto } from "./conversation.dto";
import { UserDto } from "./user.dto";

export interface MessageDto
{
  id: number;
  sender: UserDto; // Assuming User model exists
  message: string;
  sendAt: Date;
  isRead: boolean;
  conversation: ConversationDto; // Assuming Conversation model exists


}
