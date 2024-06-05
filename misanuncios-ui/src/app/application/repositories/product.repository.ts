import { Observable } from "rxjs";
import { Product } from "../../domain/model/product.model";



export abstract class ProductRepository {

  abstract getAllProducts(pageIndex:number ,pageSize:number): Observable<Product[]>;
  abstract getAllProductsBySearch(search:string): Observable<Product[]>;
  abstract getAllProductsByCategories(category:string[]): Observable<Product[]>;
  abstract getProductByUser(): Observable<Product[]>;
  abstract save(product:Product):Observable<Product>;
  abstract delete(id:number):Observable<void>;
  abstract getProductById(id:number):Observable<Product>;

}
