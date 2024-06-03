import { PermissionDto } from "../dto/permission.dto";
import { RoleDto } from "../dto/role.dto";
import { Permission } from "../../domain/model/permission.model";
import { Role } from "../../domain/model/role.model";
import { RoleMapper } from "./role.mapper";
import { UserHasPermissionMapper } from "./userHasPermission.mapper";
import { UserHasRoleMapper } from "./userHasRole.mapper";


export class PermissionMapper {
 static toDomain(dto: PermissionDto): Permission {
   return {
     id: dto.id,
     name: dto.name,

   };
 }

 static toDto(domain: Permission): PermissionDto {
   return {
     id: domain.id,
     name: domain.name,

   };
 }
}
