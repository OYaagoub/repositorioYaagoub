import { UserHasRoleDto } from "../dto/userHasRole.dto";
import { UserHasRole } from "../../domain/model/userHasRole.model";
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
