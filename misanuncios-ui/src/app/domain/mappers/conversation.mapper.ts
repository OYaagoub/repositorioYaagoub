import { CategoryDto } from "../../infrastructure/dto/category.dto";
import { ConversationDto } from "../../infrastructure/dto/conversation.dto";
import { ImageDto } from "../../infrastructure/dto/image.dto";
import { Category } from "../model/category.model";
import { Conversation } from "../model/conversation.model";
import { Image } from "../model/image.model";
import { MessageMapper } from "./message.mapper";
import { ProductMapper } from "./product.mapper";
import { UserMapper } from "./user.mapper";
export class ConversationMapper {
  static toDomain(dto: ConversationDto): Conversation {
    return {
      id: dto.id,

      product:ProductMapper.toDomain(dto.product),
      sender:UserMapper.toDomain(dto.sender)

    };

  }
  static toDto(domain: Conversation): ConversationDto {
    return {
      id: domain.id,
     
      product:ProductMapper.toDto(domain.product),
      sender:UserMapper.toDto(domain.sender)

    };

  }

}
