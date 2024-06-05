import { UserDto } from "../dto/user.dto";
import { User } from "../../domain/model/user.model";


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
