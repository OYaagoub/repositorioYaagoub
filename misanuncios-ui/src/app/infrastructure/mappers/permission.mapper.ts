import { PermissionDto } from "../dto/permission.dto";
import { Permission } from "../../domain/model/permission.model";


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
