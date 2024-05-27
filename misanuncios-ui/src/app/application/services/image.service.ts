import { Injectable } from "@angular/core";
import { ImageRepository } from "../repositories/image.repository";
import { Image } from "../../domain/model/image.model";
import { Observable } from "rxjs";




@Injectable({
  providedIn: 'root',
})
export class ImageService {

  constructor(private imageRepository:ImageRepository) { }

  save(image:Image){
    return this.imageRepository.save(image);
  }
  delete(id:string):void{
    return this.imageRepository.delete(id);
  }
  findByProduct(idProduct:number):Observable<Image[]>{
    return this.imageRepository.findByProduct(idProduct);
  }





}
