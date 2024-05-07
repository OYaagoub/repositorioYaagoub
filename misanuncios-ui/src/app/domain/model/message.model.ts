import { Conversation } from "./conversation.model";
import { User } from "./user.model";

export class Message
{
  id!: number;
  sender!: User; // Assuming User model exists
  message!: string;
  sendAt!: Date;
  isRead!: boolean;
  conversation!: Conversation; // Assuming Conversation model exists

  constructor(data:Partial<Message>){
    Object.assign(this, data);
  }
}
