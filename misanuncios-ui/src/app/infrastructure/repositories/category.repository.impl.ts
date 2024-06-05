import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { CategoryRepository } from '../../application/repositories/category.repository';
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
