import { CategoryDto } from "../dto/category.dto";
import { ImageDto } from "../dto/image.dto";
import { UserHasRoleDto } from "../dto/userHasRole.dto";
import { Category } from "../../domain/model/category.model";
import { Image } from "../../domain/model/image.model";
import { UserHasRole } from "../../domain/model/userHasRole.model";
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
