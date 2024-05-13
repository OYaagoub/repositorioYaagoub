import { CategoryDto } from "../../infrastructure/dto/category.dto";
import { ImageDto } from "../../infrastructure/dto/image.dto";
import { MessageDto } from "../../infrastructure/dto/message.dto";
import { Category } from "../model/category.model";
import { Image } from "../model/image.model";
import { Message } from "../model/message.model";
import { ConversationMapper } from "./conversation.mapper";
import { ProductMapper } from "./product.mapper";
import { UserMapper } from "./user.mapper";
export class MessageMapper {
  static toDomain(dto: MessageDto): Message {
    return {
      id: dto.id,
      isRead:dto.isRead,
      message:dto.message,
      sendAt:dto.sendAt,
      sender:UserMapper.toDomain(dto.sender),
      conversation:ConversationMapper.toDomain(dto.conversation)


    };

  }
  static toDto(domain: Message): MessageDto {
    return {
      id: domain.id,
      isRead:domain.isRead,
      message:domain.message,
      sendAt:domain.sendAt,
      sender:UserMapper.toDto(domain.sender),
      conversation:ConversationMapper.toDto(domain.conversation)


    };

  }

}
