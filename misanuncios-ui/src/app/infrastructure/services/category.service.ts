import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, map, of } from 'rxjs';
import { User } from '../../domain/model/user.model';
import { UserDto } from '../dto/user.dto';
import { UserMapper } from '../../domain/mappers/user.mapper';
import { config } from '../config/config';
import { Category } from '../../domain/model/category.model';
import { CategoryDto } from '../dto/category.dto';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  constructor(private http: HttpClient) { }
  getCategories(): Observable<Category[]> {
    const url = `${config['contentUrl']}/categories`;
    return this.http.get<CategoryDto[]>(url).pipe();
  }
}
