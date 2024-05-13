import { CategoryDto } from "../../infrastructure/dto/category.dto";
import { ImageDto } from "../../infrastructure/dto/image.dto";
import { UserHasPermissionDto } from "../../infrastructure/dto/userHasPermission.dto";
import { UserHasRoleDto } from "../../infrastructure/dto/userHasRole.dto";
import { Category } from "../model/category.model";
import { Image } from "../model/image.model";
import { UserHasPermission } from "../model/userHasPermission.model";
import { UserHasRole } from "../model/userHasRole.model";
import { PermissionMapper } from "./permission.mapper";
import { ProductMapper } from "./product.mapper";
import { RoleMapper } from "./role.mapper";
import { UserMapper } from "./user.mapper";
export class UserHasPermissionMapper {
  static toDomain(dto: UserHasPermissionDto): UserHasPermission {
    return {
      id: dto.id,
      permission:PermissionMapper.toDomain(dto.permission),
      user:UserMapper.toDto(dto.user)



    };

  }
  static toDto(domain: UserHasPermission): UserHasPermissionDto {
    return {
      id: domain.id,
      permission:PermissionMapper.toDto(domain.permission),
      user:UserMapper.toDto(domain.user)


    };

  }

}
