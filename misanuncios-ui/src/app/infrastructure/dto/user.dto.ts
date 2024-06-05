export interface UserDto {

  id: number;
  name: string;
  image: string | null;
  email: string;
  birth: Date | null;
  password: string | null;
  remember_token: string | null;
  email_verified_at: Date | null;
  //roles: UserHasRoleDto[] ; // Assuming UserHasRole model exists
  //permissions:UserHasPermissionDto[] ; // Assuming UserHasPermission model exists




}
