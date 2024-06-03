import { CategoryDto } from "../dto/category.dto";
import { ImageDto } from "../dto/image.dto";
import { NotificationDto } from "../dto/notification.dto";
import { Category } from "../../domain/model/category.model";
import { Image } from "../../domain/model/image.model";
import { Notification } from "../../domain/model/notification.model";
import { MessageMapper } from "./message.mapper";
import { ProductMapper } from "./product.mapper";
import { UserMapper } from "./user.mapper";
export class NotificationMapper {
  static toDomain(dto: NotificationDto): Notification {
    return {
      id:dto.id,
      message:dto.message,
      sendAt:dto.sendAt,
      user:dto.user ? UserMapper.toDto(dto.user) : null



    };

  }
  static toDto(domain: Notification): NotificationDto {
    return {
      id:domain.id,
      message:domain.message,
      sendAt:domain.sendAt,
      user:domain.user ? UserMapper.toDto(domain.user) : null



    };

  }

}
