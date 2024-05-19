import { Observable } from "rxjs";
import { Role } from "../model/role.model";
import { User } from "../model/user.model";
import { LoginResponse } from "../../infrastructure/dto/loginResponse.dto";
import { UserDto } from "../../infrastructure/dto/user.dto";
import { Category } from "../model/category.model";
import { Product } from "../model/product.model";



export abstract class ProductRepository {

  abstract getAllProducts(pageIndex:number ,pageSize:number): Observable<Product[]>;
  abstract getAllProductsBySearch(search:string): Observable<Product[]>;
  abstract getAllProductsByCategories(category:string[]): Observable<Product[]>;



}
