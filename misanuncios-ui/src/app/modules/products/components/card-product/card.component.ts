import { Component, Input } from '@angular/core';
import { RouterLink } from '@angular/router';
import { Product } from '../../../../domain/model/product.model';
import { ImageService } from '../../../../application/services/image.service';
import { ImageRepository } from '../../../../application/repositories/image.repository';
import { ImageRepositoryImpl } from '../../../../infrastructure/repositories/image.repository.impl';
import { ProductService } from '../../../../application/services/product.service';

@Component({
  selector: 'app-card',
  standalone: true,
  imports: [RouterLink],
  templateUrl: './card.component.html',
  styleUrl: './card.component.scss',

})
export class CardComponent {
  @Input() product!: Product;


  constructor() {

  }




}
