import { UserDto } from "./user.dto";

export interface NotificationDto {
  id: number;
  message: string;
  sendAt:Date;
  user: UserDto | null; // Assuming User model exists

}
