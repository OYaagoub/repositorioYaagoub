import { Observable } from "rxjs";
import { Role } from "../../domain/model/role.model";
import { User } from "../../domain/model/user.model";
import { LoginResponse } from "../../infrastructure/dto/loginResponse.dto";
import { UserDto } from "../../infrastructure/dto/user.dto";
import { Category } from "../../domain/model/category.model";
import { Product } from "../../domain/model/product.model";



export abstract class ProductRepository {

  abstract getAllProducts(pageIndex:number ,pageSize:number): Observable<Product[]>;
  abstract getAllProductsBySearch(search:string): Observable<Product[]>;
  abstract getAllProductsByCategories(category:string[]): Observable<Product[]>;
  abstract getProductByUser(): Observable<Product[]>;
  abstract save(product:Product):Observable<Product>;
  abstract delete(id:number):Observable<void>;

}
