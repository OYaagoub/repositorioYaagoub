import { Component } from '@angular/core';
import { CardComponent } from '../../../products/components/card-product/card.component';
import { ProductRepository } from '../../../../application/repositories/product.repository';
import { ProductRepositoryImpl } from '../../../../infrastructure/repositories/product.repository.impl';
import { ProductService } from '../../../../application/services/product.service';
import { Product } from '../../../../domain/model/product.model';
import { UpdateComponent } from '../../../products/components/crud/update/update.component';

@Component({
  selector: 'app-my-products',
  standalone: true,
  imports: [CardComponent , UpdateComponent],
  templateUrl: './my-products.component.html',
  styleUrl: './my-products.component.scss',
  providers:[
    ProductService,
    {provide:ProductRepository,useClass:ProductRepositoryImpl}
  ]
})
export class MyProductsComponent {
  product!:Product;
  isOpen:boolean = false;
  myProducts:Product[] = [];
  constructor(private productService:ProductService){}


  ngOnInit(): void {
    this.productService.getProductsByUser().subscribe(products=>{
      this.myProducts = products;
    })
  }
  openIn(){
    this.isOpen=this.isOpen?false:true;
   }

  setProduct(product:Product){
    this.product = product;
    this.openIn();
  }
  deleteProduct(product:Product){
    // const confirmation = confirm('Are you sure you want to delete this product?');
    // if (confirmation) {
    // }
    this.productService.delete(product.id).subscribe(() => {
      // Remove the deleted product from the list
      this.myProducts = this.myProducts.filter(p => p.id !== product.id);
    });
  }

}
