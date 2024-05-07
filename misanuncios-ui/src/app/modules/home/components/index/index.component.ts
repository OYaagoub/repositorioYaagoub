import { Component } from '@angular/core';
import { CardComponent } from '../../../products/components/card-product/card.component';

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [CardComponent],
  templateUrl: './index.component.html',
  styleUrl: './index.component.scss'
})
export class IndexComponent {

}
