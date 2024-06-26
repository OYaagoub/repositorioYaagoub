import { Component, EventEmitter, Input, Output } from '@angular/core';
import { CategoryRepository } from '../../../../../application/repositories/category.repository';
import { CategoryRepositoryImpl } from '../../../../../infrastructure/repositories/category.repository.impl';
import { FormBuilder, FormGroup, FormsModule, ReactiveFormsModule, Validators } from '@angular/forms';
import { Product } from '../../../../../domain/model/product.model';
import { ProductService } from '../../../../../application/services/product.service';
import { ProductRepository } from '../../../../../application/repositories/product.repository';
import { ProductRepositoryImpl } from '../../../../../infrastructure/repositories/product.repository.impl';
import { Category } from '../../../../../domain/model/category.model';
import { Image } from '../../../../../domain/model/image.model';
import { ImageService } from '../../../../../application/services/image.service';
import { ImageRepository } from '../../../../../application/repositories/image.repository';
import { ImageRepositoryImpl } from '../../../../../infrastructure/repositories/image.repository.impl';
import { Router } from '@angular/router';
import { NgxSpinnerService } from 'ngx-spinner';
import { AlertsService } from '../../../../../infrastructure/services/alerts.service';

@Component({
  selector: 'app-update',
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule],
  templateUrl: './update.component.html',
  styleUrl: './update.component.scss',
  providers: [
    ProductService,
    {provide: CategoryRepository, useClass: CategoryRepositoryImpl},
    {provide:ProductRepository,useClass:ProductRepositoryImpl},
    ImageService,
    {provide:ImageRepository,useClass:ImageRepositoryImpl}
  ],
})
export class UpdateComponent {
  @Input() isOpen!:boolean;
  @Input() productToUpdate:Product = new Product({});
  @Output() childEvent = new EventEmitter<void>();
  base64ImagesUpdate: Image[]=[];
  categories!: string[];
  fromProduct!:FormGroup;
constructor(private alerts:AlertsService,private spinner: NgxSpinnerService,private router : Router,private categoryRepository: CategoryRepository,private formBulder:FormBuilder,private productService:ProductService,private imageService:ImageService){

}

  emitEvent() {
    this.childEvent.emit();
  }

  ngOnInit(): void {

    this.categoryRepository.getAllCategoriesByName().subscribe(categories => {
      this.categories = categories;

    })
  }
  ngOnChanges(): void {
    this.initializeForm();
    if(this.productToUpdate?.id){
      this.base64ImagesUpdate = [];
      this.productToUpdate.images?.forEach(image => {
        this.base64ImagesUpdate.push(image);
      })
      // this.imageService.findByProduct(this.productToUpdate.id).subscribe(images => {
      //   this.base64ImagesUpdate = images; // Assuming the images are already converted to base64
      // })
    }
  }

  initializeForm(): void {
    this.fromProduct = this.formBulder.group({
      title: [this.productToUpdate?.title || '', [Validators.required, Validators.minLength(20), Validators.maxLength(120)]],
      description: [this.productToUpdate?.description || '', [Validators.required, Validators.maxLength(5000), Validators.minLength(20)]],
      price: [this.productToUpdate?.price || 0, [Validators.required, Validators.min(1), Validators.max(1000000000)]],
      category: [this.productToUpdate?.category?.name || '', Validators.required],
      imageUpdate: [null, [Validators.nullValidator]],
    });
  }

  onFileSelecteds(event: Event): void {

    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      this.convertToBase64U(file);
    }
  }
  updateProduct(){
    if(this.fromProduct.valid){
      this.spinner.show();
      const product = new Product({
        id:this.productToUpdate.id,
        title:this.fromProduct.value.title,
        description:this.fromProduct.value.description,
        price:this.fromProduct.value.price,
        category:new Category({name:this.fromProduct.value.category}),
        });
      this.productService.save(product).subscribe(product => {
        this.alerts.showSuccess("Producto actualizado con éxito")
        this.emitEvent();
        this.fromProduct.reset();
        this.spinner.hide();
        this.navigateToMyProducts();
      })
    }

  }

  navigateToMyProducts() {
    const uniqueId = new Date().getTime();
    this.router.navigate([`/workspace/myProducts`, uniqueId]);
  }
  convertToBase64U(file: File): void {

    const readerU = new FileReader();
    readerU.onload = () => {
      console.log(readerU.result as string)

      this.spinner.show();
        this.imageService.save(readerU.result as string,this.productToUpdate.id).subscribe(image => {
            // console.log(image);
            this.alerts.showSuccess("Imagen agregada con éxito")
            this.base64ImagesUpdate.push(image);
            this.spinner.hide();
        })


    };
    readerU.readAsDataURL(file);
  }

  deleteImageU(image: Image){
    const index = this.base64ImagesUpdate.indexOf(image);
    this.spinner.show();
    this.imageService.delete(image.id).subscribe
    (status => {
      if(status){
        this.alerts.showSuccess("Imagen eliminada con éxito")
        if (index > -1) {
          this.base64ImagesUpdate.splice(index, 1);
        }

      }
      this.spinner.hide();
    })
  }
}
