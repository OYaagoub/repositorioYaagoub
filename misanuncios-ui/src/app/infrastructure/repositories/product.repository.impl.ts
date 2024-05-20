import { Injectable } from '@angular/core';
import { AuthRepository } from '../../application/repositories/auth.repository';
import { User } from '../../domain/model/user.model';
import { AuthService } from '../services/auth.service';
import { UserMapper } from '../mappers/user.mapper';
import { Observable } from 'rxjs';
import { LoginResponse } from '../dto/loginResponse.dto';
import { UserDto } from '../dto/user.dto';
import { CategoryRepository } from '../../application/repositories/category.repository';
import { Category } from '../../domain/model/category.model';
import { CategoryService } from '../services/category.service';
import { ProductRepository } from '../../application/repositories/product.repository';
import { Product } from '../../domain/model/product.model';
import { ProductService } from '../services/product.service';

@Injectable({
 providedIn: 'root',
})
export class ProductRepositoryImpl implements ProductRepository {


 constructor(private productService: ProductService) {}
  getAllProductsByCategories(categoriesName: string[]): Observable<Product[]> {
    return this.productService.getAllProductsByCategories(categoriesName);
  }

  getAllProductsBySearch(search: string): Observable<Product[]> {
    return this.productService.getAllProductsBySearch(search);
  }
  getAllProducts(pageIndex:number ,pageSize:number): Observable<Product[]> {
    return this.productService.getProducts(pageIndex,pageSize);
  }






}
