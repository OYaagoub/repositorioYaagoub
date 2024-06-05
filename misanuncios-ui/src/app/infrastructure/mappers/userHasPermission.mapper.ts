import { UserHasPermissionDto } from "../dto/userHasPermission.dto";
import { UserHasPermission } from "../../domain/model/userHasPermission.model";
import { PermissionMapper } from "./permission.mapper";
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
