import { Component } from '@angular/core';
import { CardComponent } from '../../../products/components/card-product/card.component';
import { CategoryRepository } from '../../../../application/repositories/category.repository';
import { CategoryRepositoryImpl } from '../../../../infrastructure/repositories/category.repository.impl';
import { Category } from '../../../../domain/model/category.model';

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [CardComponent],
  templateUrl: './index.component.html',
  styleUrl: './index.component.scss',
  providers:[
    {provide:CategoryRepository,useClass:CategoryRepositoryImpl}
  ]
})
export class IndexComponent {
  categoriesWithProducts!:Category[];
  constructor(private categoryRepository:CategoryRepository){}

  ngOnInit(): void {
    this.categoryRepository.getAllWithProducts().subscribe(categories => {
      this.categoriesWithProducts=categories;
    });
  }

}
