import { ConversationDto } from "./conversation.dto";
import { UserHasRoleDto } from "./userHasRole.dto";
import { ProductDto } from "./product.dto";
import { UserHasPermissionDto } from "./userHasPermission.dto";
import { NotificationDto } from "./notification.dto";

export interface UserDto {

  id: number;
  name: string;
  image: string | null;
  email: string;
  birth: Date | null;
  password: string | null;
  remember_token: string | null;
  email_verified_at: Date | null;
  //roles: UserHasRoleDto[] ; // Assuming UserHasRole model exists
  //permissions:UserHasPermissionDto[] ; // Assuming UserHasPermission model exists




}
