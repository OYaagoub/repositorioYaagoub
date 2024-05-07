import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListProductsComponent } from './components/list-products/list-products.component';
import { ProductOverviewsComponent } from './components/product-overviews/product-overviews.component';

const routes: Routes = [
  // Add routes here
  { path: '', component: ListProductsComponent, },
  {
    path: 'product/:id',
    component:ProductOverviewsComponent,
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ProductsRoutingModule { }
