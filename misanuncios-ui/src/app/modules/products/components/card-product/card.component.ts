import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Product } from '../../../../domain/model/product.model';
import { ImageService } from '../../../../application/services/image.service';
import { ImageRepository } from '../../../../application/repositories/image.repository';
import { ImageRepositoryImpl } from '../../../../infrastructure/repositories/image.repository.impl';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss',
  providers: [ImageService,
    {
      provide: ImageRepository,
      useClass: ImageRepositoryImpl,
    }],
})
export class CardComponent {
  @Input() product!: Product;
  images!: string[];
  intervalId: any;
  image!: string;

  constructor(private imageService: ImageService) {

  }

  ngOnInit() {
    if (this.product) {

      this.imageService.findByProduct(this.product.id).subscribe(image => {
        this.images = image.map(img => img.path);
        this.image = this.images[Math.floor(Math.random() * (this.images ? this.images.length : 1))];
      })


    }
  }
  ngOnChanges(){
  }


}
