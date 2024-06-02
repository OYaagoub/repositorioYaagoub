import { Component, OnDestroy, OnInit } from '@angular/core';
import { CardComponent } from '../../../products/components/card-product/card.component';
import { ProductRepository } from '../../../../application/repositories/product.repository';
import { ProductRepositoryImpl } from '../../../../infrastructure/repositories/product.repository.impl';
import { ProductService } from '../../../../application/services/product.service';
import { Product } from '../../../../domain/model/product.model';
import { UpdateComponent } from '../../../products/components/crud/update/update.component';
import { NgxSpinnerService } from 'ngx-spinner';
import { Subscription } from 'rxjs';
import { ActivatedRoute } from '@angular/router';
import { AlertsService } from '../../../../infrastructure/services/alerts.service';

@Component({
  selector: 'app-my-products',
  standalone: true,
  imports: [CardComponent , UpdateComponent],
  templateUrl: './my-products.component.html',
  styleUrls: ['./my-products.component.scss'],
  providers:[
    ProductService,
    {provide: ProductRepository, useClass: ProductRepositoryImpl}
  ]
})
export class MyProductsComponent implements OnInit, OnDestroy {
  product!: Product;
  isOpen: boolean = false;
  myProducts: Product[] = [];
  location!: number;
  private routeSub!: Subscription;

  constructor(
    private route: ActivatedRoute,
    private spinner: NgxSpinnerService,
    private productService: ProductService,
    private alerts:AlertsService,
  ) {}

  ngOnInit(): void {
    this.routeSub = this.route.params.subscribe(params => {
      this.location = +params['reload'];
      this.loadProducts();
    });
  }

  ngOnDestroy(): void {
    if (this.routeSub) {
      this.routeSub.unsubscribe();
    }
  }

  loadProducts(): void {
    this.spinner.show();
    this.productService.getProductsByUser().subscribe(products => {
      this.myProducts = products;
      this.spinner.hide();
    });
  }

  openIn() {
    this.isOpen = !this.isOpen;
  }

  setProduct(product: Product) {
    this.product = product;
    this.openIn();
  }

  deleteProduct(product: Product) {
    this.productService.delete(product.id).subscribe(() => {
      this.alerts.showSuccess("Producto eliminado correctamente")
      this.myProducts = this.myProducts.filter(p => p.id !== product.id);
    });
  }
}
