import { Component } from '@angular/core';
import { CardComponent } from '../card-product/card.component';
import { ProductService } from '../../../../infrastructure/services/product.service';
import { Product } from '../../../../domain/model/product.model';

@Component({
  selector: 'app-list-products',
  standalone: true,
  imports: [CardComponent],
  templateUrl: './list-products.component.html',
  styleUrl: './list-products.component.scss'
})
export class ListProductsComponent {
  constructor(private productService:ProductService){}

  products:Product[] = [];
  pageSize = 10;
  pageIndex = 0;
  totalItems = 0;


  ngOnInit(): void {
    this.productService.getProducts(this.pageIndex,this.pageSize).subscribe(products => this.products = products);
    //this.products = this.productService.getAll();
  }
  ngOnChanges(): void {
    this.productService.getProducts(this.pageIndex,this.pageSize).subscribe(products => this.products = products);
  }
  pageIndexFunction(event: any) {
    this.pageIndex = event.target.dataset.number;
  
    this.ngOnChanges()
  }
}
