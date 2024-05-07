import { Component, OnInit } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { initFlowbite } from 'flowbite';
import { FooterComponent } from './modules/includes/footer/footer.component';
import { NavbarComponent } from './modules/includes/navbar/navbar.component';
@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet,FooterComponent,NavbarComponent],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit{
  title = 'misanuncios-ui';
  ngOnInit(): void {
    try {
      initFlowbite();
    }catch(e) {
      // Handle cache errors
    };
  }
}
