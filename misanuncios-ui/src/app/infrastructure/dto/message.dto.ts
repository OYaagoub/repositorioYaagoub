import { ConversationDto } from "./conversation.dto";
import { UserDto } from "./user.dto";

export interface MessageDto
{
  id: number;
  sender: UserDto | null | number; // Assuming User model exists
  message: string;
  sendAt: Date;
  isRead: boolean;
  conversation: ConversationDto | null; // Assuming Conversation model exists


}
