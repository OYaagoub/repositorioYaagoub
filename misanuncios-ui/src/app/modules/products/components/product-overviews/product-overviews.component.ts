import { Component } from '@angular/core';
import { Product } from '../../../../domain/model/product.model';
import { ActivatedRoute, RouterLink } from '@angular/router';
import { ProductService } from '../../../../application/services/product.service';
import { ProductRepository } from '../../../../application/repositories/product.repository';
import { ProductRepositoryImpl } from '../../../../infrastructure/repositories/product.repository.impl';
import { ImageService } from '../../../../application/services/image.service';
import { ImageRepository } from '../../../../application/repositories/image.repository';
import { ImageRepositoryImpl } from '../../../../infrastructure/repositories/image.repository.impl';
import { Image } from '../../../../domain/model/image.model';


@Component({
  selector: 'app-product-overviews',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './product-overviews.component.html',
  styleUrl: './product-overviews.component.scss',
  providers:[
    ProductService,
    {provide:ProductRepository,useClass:ProductRepositoryImpl},
    ImageService,
    {provide:ImageRepository,useClass:ImageRepositoryImpl}
  ]
})
export class ProductOverviewsComponent {
    product:Product=new Product({});
    images:Image[]=[];
    idProduct!:number;
    constructor(private route:ActivatedRoute,private productService:ProductService,private imageService : ImageService){
      this.route.params.subscribe(params=>{
        this.idProduct=params['id'];

      })
    }


    ngOnInit(): void {
      this.productService.getProductById(this.idProduct).subscribe(product=>{
        this.product=product;
        console.log(product);

      })
      this.imageService.findByProduct(this.idProduct).subscribe(images=>{
        this.images=images;
        // this.product.images=images;
      })
    }





}
