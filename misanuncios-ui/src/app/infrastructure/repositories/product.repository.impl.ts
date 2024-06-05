import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { ProductRepository } from '../../application/repositories/product.repository';
import { Product } from '../../domain/model/product.model';
import { ProductService } from '../services/product.service';

@Injectable({
 providedIn: 'root',
})
export class ProductRepositoryImpl implements ProductRepository {


 constructor(private productService: ProductService) {}
  delete(id: number): Observable<void> {
    return this.productService.delete(id);
  }
  save(product: Product): Observable<Product> {
    return  this.productService.save(product);
  }
  getProductByUser(): Observable<Product[]> {
    return this.productService.getProductsByUser();
  }
  getAllProductsByCategories(categoriesName: string[]): Observable<Product[]> {
    return this.productService.getAllProductsByCategories(categoriesName);
  }

  getAllProductsBySearch(search: string): Observable<Product[]> {
    return this.productService.getAllProductsBySearch(search);
  }
  getAllProducts(pageIndex:number ,pageSize:number): Observable<Product[]> {
    return this.productService.getProducts(pageIndex,pageSize);
  }

  getProductById(id: number):Observable<Product>{
    return this.productService.getProductById(id);
  }




}
