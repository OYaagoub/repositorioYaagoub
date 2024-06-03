import { Component } from '@angular/core';
import { CardComponent } from '../../../products/components/card-product/card.component';
import { CategoryRepository } from '../../../../application/repositories/category.repository';
import { CategoryRepositoryImpl } from '../../../../infrastructure/repositories/category.repository.impl';
import { Category } from '../../../../domain/model/category.model';
import { Product } from '../../../../domain/model/product.model';
import { NgxSpinnerService } from 'ngx-spinner';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [CardComponent,RouterLink],
  templateUrl: './index.component.html',
  styleUrl: './index.component.scss',
  providers:[
    {provide:CategoryRepository,useClass:CategoryRepositoryImpl}
  ]
})
export class IndexComponent {
  categoriesWithProducts!:Category[];
  constructor(private categoryRepository:CategoryRepository,private spinner: NgxSpinnerService){}

  ngOnInit(): void {
    this.spinner.show();
    setTimeout(() => {
      /** spinner ends after 5 seconds */
      this.spinner.hide();
    }, 5000);
    this.categoryRepository.getAllWithProducts().subscribe(categories => {
      this.categoriesWithProducts=categories;
      //this.spinner.hide();
    });
  }

  getTopProducts(products: Product[]): any[] {
    return products.slice(0, 3);
  }

}
