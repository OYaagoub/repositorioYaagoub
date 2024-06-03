import { Component, ViewChild } from '@angular/core';
import { CardComponent } from '../card-product/card.component';
import { ProductService } from '../../../../infrastructure/services/product.service';
import { Product } from '../../../../domain/model/product.model';
import { CategoryRepository } from '../../../../application/repositories/category.repository';
import { CategoryRepositoryImpl } from '../../../../infrastructure/repositories/category.repository.impl';
import { ProductRepository } from '../../../../application/repositories/product.repository';
import { ProductRepositoryImpl } from '../../../../infrastructure/repositories/product.repository.impl';
import { NgxMasonryComponent, NgxMasonryModule } from 'ngx-masonry';
import { NgxSpinnerService } from 'ngx-spinner';
@Component({
  selector: 'app-list-products',
  standalone: true,
  imports: [CardComponent,NgxMasonryModule],
  templateUrl: './list-products.component.html',
  styleUrl: './list-products.component.scss',
  providers:[
    {provide:CategoryRepository,useClass:CategoryRepositoryImpl},
    {provide:ProductRepository,useClass:ProductRepositoryImpl}
  ]
})
export class ListProductsComponent {
  @ViewChild(NgxMasonryComponent) masonry!: NgxMasonryComponent;
  constructor(private spinner: NgxSpinnerService,private productRepository:ProductRepository,private categoryRepository:CategoryRepository){}
  categoriesQuery:string[]=[];
  categories!:string[] ;
  isLoadingSearch:boolean = false;
  searchQuery:string = "";
  products:Product[] = [];
  pageSize = 10;
  pageIndex = 0;
  totalItems = 0;
  isOpenOrder:boolean = false;
  isOpenFilter:boolean = false;


  ngOnInit(): void {
    this.spinner.show();
    this.productRepository.getAllProducts(this.pageIndex,this.pageSize).subscribe(products => this.products = products);
    //this.products = this.productService.getAll();
    this.categoryRepository.getAllCategoriesByName().subscribe(categories =>
      {
        this.categories = categories;
        this.spinner.hide();
      });

  }
  ngOnChanges(): void {
    this.spinner.show();
    this.productRepository.getAllProducts(this.pageIndex,this.pageSize).subscribe(products => {
      this.products = products;
      this.spinner.hide();
    });
  }
  isOpenOrderFn(){
    this.isOpenOrder = !this.isOpenOrder;
    this.isOpenFilter = false;
  }
  isOpenFilterFn(){
    
    this.isOpenFilter = !this.isOpenFilter;
    this.isOpenOrder = false;
  }

  pageIndexFunction(event: any) {
    this.pageIndex = event.target.dataset.number;

    this.ngOnChanges()
  }
  onBackToFirstPage() {
    this.pageIndex = 0;
    this.ngOnChanges()
  }
  search(event: any) {
    this.spinner.show();
    this.isLoadingSearch=true;
    this.searchQuery = event.target.value;
    this.productRepository.getAllProductsBySearch(this.searchQuery).subscribe(products => {
      this.products = products
      this.spinner.hide();
    })
    if(this.searchQuery == ""){
      this.isLoadingSearch=false;
      this.onBackToFirstPage()
    }

  }
  onChangeCategory( event: any){
    this.isLoadingSearch=true;
    if(this.categoriesQuery.includes(event.target.value)){
      this.categoriesQuery = this.categoriesQuery.filter(category => category != event.target.value);
    }
    else{
      const inputElement = event.target as HTMLInputElement;
      if(inputElement.checked){

        this.categoriesQuery.push(event.target.value);
      }
    }
    console.log(this.categoriesQuery);
    this.spinner.show();
    this.productRepository.getAllProductsByCategories(this.categoriesQuery).subscribe(products => {
      this.products = products;
      this.spinner.hide();

    })


    if(this.categoriesQuery.length == 0){
      this.isLoadingSearch=false;
      this.onBackToFirstPage();
    }
  }

  onIncreases(){
    this.products.sort((a,b)=>{
      const aa=parseInt(a.price.replace(".",""))
      const bb=parseInt(b.price.replace(".",""))
      return aa-bb
    });
    this.masonry.reloadItems();
    this.masonry.layout();
  }
  onDiscreases(){
    this.products.sort((a,b)=>{
      const aa=parseInt(a.price.replace(".",""))
      const bb=parseInt(b.price.replace(".",""))
      return bb-aa
    });
    this.masonry.reloadItems();
    this.masonry.layout();
  }
  parseInts(price:any){
    return parseInt(price.replace(".",""));

  }
}
