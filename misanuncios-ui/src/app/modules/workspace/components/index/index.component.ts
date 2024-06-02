import { Component } from '@angular/core';
import { ActivatedRoute, Router, RouterLink, RouterOutlet } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-index',
  standalone: true,
  imports: [RouterLink,RouterOutlet],
  templateUrl: './index.component.html',
  styleUrl: './index.component.scss'
})
export class IndexComponent {
  currentRoute!: string;
  isOrNot: boolean = false;
  constructor(private spinner: NgxSpinnerService,private router: Router,private route:ActivatedRoute){}
  ngOnInit(): void {
    this.router.events.subscribe(() => {
      this.currentRoute = this.router.url;
      if(this.router.url=='/workspace'){
        this.isOrNot = true;
      }else{
        this.isOrNot = false;
      }
    });
    this.spinner.show();
    setTimeout(() => {
      this.spinner.hide();
    }, 500);

    }


}
