import { Component } from '@angular/core';
import { Product } from '../../../../domain/model/product.model';
import { ActivatedRoute, Router, RouterLink } from '@angular/router';
import { ProductService } from '../../../../application/services/product.service';
import { ProductRepository } from '../../../../application/repositories/product.repository';
import { ProductRepositoryImpl } from '../../../../infrastructure/repositories/product.repository.impl';
import { ImageService } from '../../../../application/services/image.service';
import { ImageRepository } from '../../../../application/repositories/image.repository';
import { ImageRepositoryImpl } from '../../../../infrastructure/repositories/image.repository.impl';
import { Image } from '../../../../domain/model/image.model';
import { ConversationService } from '../../../../application/services/conversation.service';
import { ConversationRepositoryImpl } from '../../../../infrastructure/repositories/conversation.repository.impl';
import { ConversationRepository } from '../../../../application/repositories/conversation.repository';


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
    {provide:ImageRepository,useClass:ImageRepositoryImpl},
    ConversationService,
    {provide:ConversationRepository,useClass:ConversationRepositoryImpl}
  ]
})
export class ProductOverviewsComponent {
    product:Product=new Product({});
    idProduct!:number;
    constructor(private conversationService:ConversationService,private router:Router,private route:ActivatedRoute,private productService:ProductService,private imageService : ImageService){
      this.route.params.subscribe(params=>{
        this.idProduct=params['id'];

      })
    }


    ngOnInit(): void {
      this.productService.getProductById(this.idProduct).subscribe(product=>{
        this.product=product;


      })
    }
    createConversation(){
      this.conversationService.save(this.idProduct).subscribe(status=>{
        if(status){
          this.router.navigate(['/workspace/chats/ct',this.idProduct])
        }else{
          alert("error");
        }
      })

    }






}
