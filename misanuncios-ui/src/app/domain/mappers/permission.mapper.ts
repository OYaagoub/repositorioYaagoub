import { PermissionDto } from "../../infrastructure/dto/permission.dto";
import { RoleDto } from "../../infrastructure/dto/role.dto";
import { Permission } from "../model/permission.model";
import { Role } from "../model/role.model";
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
