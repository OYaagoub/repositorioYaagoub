import { RoleDto } from "../../infrastructure/dto/role.dto";
import { Role } from "../model/role.model";


export class RoleMapper {
 static toDomain(dto: RoleDto): Role {
   return {
     id: dto.id,
     name: dto.name,

   };
 }

 static toDto(domain: Role): RoleDto {
   return {
     id: domain.id,
     name: domain.name,

   };
 }
}
