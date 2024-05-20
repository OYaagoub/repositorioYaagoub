import { Observable } from "rxjs";
import { Role } from "../../domain/model/role.model";
import { User } from "../../domain/model/user.model";
import { LoginResponse } from "../../infrastructure/dto/loginResponse.dto";
import { UserDto } from "../../infrastructure/dto/user.dto";
import { Category } from "../../domain/model/category.model";



export abstract class CategoryRepository {

  abstract getAllWithProducts(): Observable<Category[]>;
  abstract getAllCategoriesByName(): Observable<string[]>;





}
