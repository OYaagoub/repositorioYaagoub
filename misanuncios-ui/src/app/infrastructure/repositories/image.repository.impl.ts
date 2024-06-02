import { Injectable } from "@angular/core";
import { ImageRepository } from "../../application/repositories/image.repository";
import { Observable } from "rxjs";
import { Image } from "../../domain/model/image.model";
import { ImageService } from "../services/image.service";




@Injectable({
  providedIn: 'root'
})

export class ImageRepositoryImpl implements ImageRepository {

  constructor(private imageService: ImageService) { }
  delete(id: number): Observable<boolean> {
    return this.imageService.delete(id);
  }

  save(image:string,product_id:number): Observable<Image> {
    return this.imageService.save(image,product_id);
  }

  findByProduct(idProduct:number): Observable<Image[]>{
    return this.imageService.findByProduct(idProduct);
  }



}
