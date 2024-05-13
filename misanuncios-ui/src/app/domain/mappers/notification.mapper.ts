import { CategoryDto } from "../../infrastructure/dto/category.dto";
import { ImageDto } from "../../infrastructure/dto/image.dto";
import { NotificationDto } from "../../infrastructure/dto/notification.dto";
import { Category } from "../model/category.model";
import { Image } from "../model/image.model";
import { Notification } from "../model/notification.model";
import { MessageMapper } from "./message.mapper";
import { ProductMapper } from "./product.mapper";
import { UserMapper } from "./user.mapper";
export class NotificationMapper {
  static toDomain(dto: NotificationDto): Notification {
    return {
      id:dto.id,
      message:dto.message,
      user:UserMapper.toDomain(dto.user)



    };

  }
  static toDto(domain: Notification): NotificationDto {
    return {
      id:domain.id,
      message:domain.message,
      user:UserMapper.toDto(domain.user)



    };

  }

}
