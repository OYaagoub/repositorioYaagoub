import { UserDto } from "./user.dto";

export interface NotificationDto {

  id: number;
  message: string;
  user: UserDto; // Assuming User model exists

}
