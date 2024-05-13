import { Observable } from "rxjs";
import { Role } from "../model/role.model";
import { User } from "../model/user.model";
import { LoginResponse } from "../../infrastructure/dto/loginResponse.dto";
import { UserDto } from "../../infrastructure/dto/user.dto";
import { Category } from "../model/category.model";



export abstract class CategoryRepository {

  abstract getAllWithProducts(): Observable<Category[]>;




}
