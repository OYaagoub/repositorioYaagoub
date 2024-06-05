import { NotificationDto } from "../dto/notification.dto";
import { Notification } from "../../domain/model/notification.model";
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
