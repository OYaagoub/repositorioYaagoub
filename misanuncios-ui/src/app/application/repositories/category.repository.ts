import { Observable } from "rxjs";
import { Category } from "../../domain/model/category.model";



export abstract class CategoryRepository {

  abstract getAllWithProducts(): Observable<Category[]>;
  abstract getAllCategoriesByName(): Observable<string[]>;





}
