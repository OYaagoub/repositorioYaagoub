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

@Component({
  selector: 'app-new',
  standalone: true,
  imports: [FormsModule,ReactiveFormsModule],
  templateUrl: './new.component.html',
  styleUrl: './new.component.scss',
  providers: [
    ProductService,
    {provide: CategoryRepository, useClass: CategoryRepositoryImpl},
    {provide:ProductRepository,useClass:ProductRepositoryImpl},
    ImageService,
    {provide:ImageRepository,useClass:ImageRepositoryImpl}
  ],
})
export class NewComponent {
  @Input() isOpen!:boolean;
  @Output() childEvent = new EventEmitter<void>();
  base64Images: string[]=[];
  categories!: string[];
  fromProduct!:FormGroup;
constructor(private router : Router,private categoryRepository: CategoryRepository,private formBulder:FormBuilder,private productService:ProductService,private imageService:ImageService){}

  emitEvent() {
    this.childEvent.emit();
  }

  ngOnInit(): void {
    this.fromProduct = this.formBulder.group({
      title: [null,[Validators.required, Validators.minLength(20),Validators.maxLength(120)]],
      description: [null,[Validators.required,Validators.maxLength(5000),Validators.minLength(20)]],
      price: [0,[Validators.required,Validators.min(1),Validators.max(1000000000)]],
      category: [null,Validators.required],
      image: [null,[Validators.required]],
    })
    this.categoryRepository.getAllCategoriesByName().subscribe(categories => {
      this.categories = categories;
    })
  }

  onFileSelected(event: Event): void {

    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      this.convertToBase64(file);
    }
  }
  addNewProduct(){
    if(this.fromProduct.valid){
      const product = new Product({
        title:this.fromProduct.value.title,
        description:this.fromProduct.value.description,
        price:this.fromProduct.value.price,
        category:new Category({name:this.fromProduct.value.category}),
        });
      this.productService.save(product).subscribe(product => {

        this.base64Images.map(image => {
          const imageToSave = new Image({
            path:image,
            product:product

          })
          this.imageService.save(imageToSave).subscribe(image => {
              // console.log(image);
          })
        })
        this.emitEvent();
        this.fromProduct.reset();
        this.router.navigate(['/workspace/myProducts']);
      })
    }

  }
  convertToBase64(file: File): void {
    
    const reader = new FileReader();
    reader.onload = () => {
      this.base64Images.push(reader.result as string);
    };
    reader.readAsDataURL(file);
  }

  deleteImage(image: string){
    const index = this.base64Images.indexOf(image);
    if (index > -1) {
      this.base64Images.splice(index, 1);
    }
  }
}
