import { Conversation } from "./conversation.model";
import { User } from "./user.model";

export class Message
{
  id!: number;
  sender!: User | null | number; // Assuming User model exists
  message!: string;
  sendAt!: Date;
  isRead!: boolean;
  conversation!: Conversation | null; // Assuming Conversation model exists

  constructor(data:Partial<Message>){
    Object.assign(this, data);
  }
}
