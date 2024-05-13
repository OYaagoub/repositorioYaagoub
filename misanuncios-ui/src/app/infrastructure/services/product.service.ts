import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map, of } from 'rxjs';
import { User } from '../../domain/model/user.model';
import { UserDto } from '../dto/user.dto';
import { UserMapper } from '../../domain/mappers/user.mapper';
import { config } from '../config/config';
import { Category } from '../../domain/model/category.model';
import { CategoryDto } from '../dto/category.dto';
import { Product } from '../../domain/model/product.model';
import { ProductDto } from '../dto/product.dto';
import { ProductMapper } from '../../domain/mappers/product.mapper';

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
}
