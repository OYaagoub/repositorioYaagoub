import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map, of } from 'rxjs';
import { User } from '../../domain/model/user.model';
import { UserDto } from '../dto/user.dto';
import { UserMapper } from '../mappers/user.mapper';
import { config } from '../config/config';
import { Category } from '../../domain/model/category.model';
import { CategoryDto } from '../dto/category.dto';
import { Product } from '../../domain/model/product.model';
import { ProductDto } from '../dto/product.dto';
import { ProductMapper } from '../mappers/product.mapper';

@Injectable({
  providedIn: 'root',
})
export class ProductService {
  constructor(private http: HttpClient) { }
  getProducts(pageIndex:number ,pageSize:number): Observable<Product[]> {
    const url = `${config['contentUrl']}/products?page=${pageIndex}&size=${pageSize}`;
    return this.http.get<ProductDto[]>(url).pipe(
      map(productsDto => productsDto.map(ProductMapper.toDomain))
    );
  }
  getAllProductsBySearch(search:string): Observable<Product[]> {
    const url = `${config['contentUrl']}/products/search?query=${search}`;
    return this.http.get<ProductDto[]>(url).pipe(
      map(productsDto => productsDto.map(ProductMapper.toDomain))
    );
  }
  getAllProductsByCategories(categoriesName:string[]): Observable<Product[]> {
    const url = `${config['contentUrl']}/products/search/categories?query=${categoriesName.join(',')}`;
    return this.http.get<ProductDto[]>(url).pipe(
      map(productsDto => productsDto.map(ProductMapper.toDomain))
    );
  }

  getProductsByUser() :Observable<Product[]> {
    const url = `${config['contentUrl']}/products/mine`;
    return this.http.get<ProductDto[]>(url).pipe(
      map(productsDto => productsDto.map(ProductMapper.toDomain))
    )

  }
  save(product:Product):Observable<Product> {
    const url = `${config['contentUrl']}/products/new`;
    return this.http.post<ProductDto>(url,ProductMapper.toDto(product)).pipe(
      map(productDto => ProductMapper.toDomain(productDto))
    );
  }
  delete(productId:number):Observable<void> {
    const url = `${config['contentUrl']}/products/delete/${productId}`;
    return this.http.delete<void>(url);
  }
}
