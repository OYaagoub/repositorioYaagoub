import { CategoryDto } from "../dto/category.dto";
import { ConversationDto } from "../dto/conversation.dto";
import { ImageDto } from "../dto/image.dto";
import { Category } from "../../domain/model/category.model";
import { Conversation } from "../../domain/model/conversation.model";
import { Image } from "../../domain/model/image.model";
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
