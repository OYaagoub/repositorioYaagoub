import { CategoryDto } from "../dto/category.dto";
import { ImageDto } from "../dto/image.dto";
import { MessageDto } from "../dto/message.dto";
import { UserDto } from "../dto/user.dto";

import { Category } from "../../domain/model/category.model";
import { Image } from "../../domain/model/image.model";
import { Message } from "../../domain/model/message.model";
import { ConversationMapper } from "./conversation.mapper";
import { ProductMapper } from "./product.mapper";
import { UserMapper } from "./user.mapper";
import { User } from "../../domain/model/user.model";
import { Conversation } from "../../domain/model/conversation.model";
export class MessageMapper {
  static toDomain(dto: MessageDto): Message {
    return {
      id: dto.id,
      isRead:dto.isRead,
      message:dto.message,
      sendAt:dto.sendAt,
      sender: dto.sender ? (dto.sender  instanceof  User ? UserMapper.toDomain(dto.sender) : dto.sender) : null,
      conversation: dto.conversation ? (dto.conversation instanceof Conversation ? ConversationMapper.toDomain(dto.conversation) : dto.conversation) :null


    };

  }
  static toDto(domain: Message): MessageDto {
    return {
      id: domain.id,
      isRead:domain.isRead,
      message:domain.message,
      sendAt:domain.sendAt,
      // sender: domain.sender ? UserMapper.toDto(domain.sender) : null,
      // conversation: domain.conversation ? ConversationMapper.toDto(domain.conversation) :null
      sender: domain.sender ? (domain.sender  instanceof  User ? UserMapper.toDomain(domain.sender) : domain.sender) : null,
      conversation: domain.conversation ? (domain.conversation instanceof Conversation ? ConversationMapper.toDomain(domain.conversation) : domain.conversation) :null


    };

  }

}
