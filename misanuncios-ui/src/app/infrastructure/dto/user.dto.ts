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
  password: string;
  remember_token: string | null;
  email_verified_at: Date | null;
  products: Set<ProductDto> ; // Assuming Product model exists
  notifications: Set<NotificationDto> ; // Assuming Notification model exists
  roles: Set<UserHasRoleDto> ; // Assuming UserHasRole model exists
  permissions: Set<UserHasPermissionDto> ; // Assuming UserHasPermission model exists
  conversations: Set<ConversationDto> ; // Assuming Conversation model exists



}
