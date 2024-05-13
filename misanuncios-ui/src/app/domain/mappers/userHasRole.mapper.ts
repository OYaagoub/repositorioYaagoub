import { CategoryDto } from "../../infrastructure/dto/category.dto";
import { ImageDto } from "../../infrastructure/dto/image.dto";
import { UserHasRoleDto } from "../../infrastructure/dto/userHasRole.dto";
import { Category } from "../model/category.model";
import { Image } from "../model/image.model";
import { UserHasRole } from "../model/userHasRole.model";
import { ProductMapper } from "./product.mapper";
import { RoleMapper } from "./role.mapper";
import { UserMapper } from "./user.mapper";
export class UserHasRoleMapper {
  static toDomain(dto: UserHasRoleDto): UserHasRole {
    return {
      id: dto.id,
      role:RoleMapper.toDomain(dto.role),
      user:UserMapper.toDomain(dto.user)


    };

  }
  static toDto(domain: UserHasRole): UserHasRoleDto {
    return {
      id: domain.id,
      role:RoleMapper.toDto(domain.role),
      user:UserMapper.toDto(domain.user)


    };

  }

}
