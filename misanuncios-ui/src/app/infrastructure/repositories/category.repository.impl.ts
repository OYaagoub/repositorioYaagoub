import { Injectable } from '@angular/core';
import { AuthRepository } from '../../domain/repositories/auth.repository';
import { User } from '../../domain/model/user.model';
import { AuthService } from '../services/auth.service';
import { UserMapper } from '../../domain/mappers/user.mapper';
import { Observable } from 'rxjs';
import { LoginResponse } from '../dto/loginResponse.dto';
import { UserDto } from '../dto/user.dto';
import { CategoryRepository } from '../../domain/repositories/category.repository';
import { Category } from '../../domain/model/category.model';
import { CategoryService } from '../services/category.service';

@Injectable({
 providedIn: 'root',
})
export class CategoryRepositoryImpl implements CategoryRepository {


 constructor(private categoryService: CategoryService) {}
 getAllCategoriesByName(): Observable<string[]> {
    return this.categoryService.getAllCategoriesByName();
  }

  getAllWithProducts(): Observable<Category[]> {
      return this.categoryService.getCategories();
  }





}
