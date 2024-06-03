import { ProductDto } from "../dto/product.dto";
import { RoleDto } from "../dto/role.dto";
import { UserDto } from "../dto/user.dto";
import { Product } from "../../domain/model/product.model";
import { Role } from "../../domain/model/role.model";
import { User } from "../../domain/model/user.model";
import { ConversationMapper } from "./conversation.mapper";
import { NotificationMapper } from "./notification.mapper";
import { ProductMapper } from "./product.mapper";
import { RoleMapper } from "./role.mapper";
import { UserHasPermissionMapper } from "./userHasPermission.mapper";
import { UserHasRoleMapper } from "./userHasRole.mapper";


export class UserMapper {
 static toDomain(dto: UserDto): User {

   return {
     id:dto.id,
     name:dto.name,
     image:dto.image,
     email:dto.email,
     birth:dto.birth,
     password:dto.password,
     remember_token:dto.remember_token,
     email_verified_at:dto.email_verified_at,



   };
 }

 static toDto(domain: User): UserDto {
  return {
    id:domain.id,
    name:domain.name,
    image:domain.image,
    email:domain.email,
    birth:domain.birth,
    password:domain.password,
    remember_token:domain.remember_token,
    email_verified_at:domain.email_verified_at,


  };
 }
}
