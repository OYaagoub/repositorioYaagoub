import { Component } from '@angular/core';
import { CardComponent } from '../../../products/components/card-product/card.component';

@Component({
  selector: 'app-my-products',
  standalone: true,
  imports: [CardComponent],
  templateUrl: './my-products.component.html',
  styleUrl: './my-products.component.scss'
})
export class MyProductsComponent {

}
