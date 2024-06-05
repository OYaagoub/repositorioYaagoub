import { ConversationDto } from "../dto/conversation.dto";
import { Conversation } from "../../domain/model/conversation.model";
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
