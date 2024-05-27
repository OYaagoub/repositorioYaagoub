import { Injectable } from "@angular/core";
import { ProductRepository } from "../repositories/product.repository";
import { Observable } from "rxjs";
import { Product } from "../../domain/model/product.model";



@Injectable({
  providedIn: 'root',
})

export class ProductService{
constructor(private productRepository:ProductRepository) {

}
  getProductsByUser(): Observable<Product[]>{
    return this.productRepository.getProductByUser();

  }
  save(product:Product):Observable<Product>{
    return this.productRepository.save(product);
  }
  delete(id:number):Observable<void>{
    return this.productRepository.delete(id);
  }

}


