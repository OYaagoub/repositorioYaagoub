import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable, map } from "rxjs";
import { Image } from "../../domain/model/image.model";
import { config } from "../config/config";
import { ImageDto } from "../dto/image.dto";
import { ImageMapper } from "../mappers/image.mapper";






@Injectable({
  providedIn: 'root'
})
export class ImageService {
  constructor(private http: HttpClient) { }

  save(image:Image): Observable<Image> {
    const url = `${config['contentUrl']}/images/new`;
    return this.http.post<ImageDto>(url, ImageMapper.toDto(image)).pipe(
      map(ImageMapper.toDomain),
    );
  }
  delete(id: string): void {
    const url = `${config['contentUrl']}/images/delete/${id}`;
    this.http.delete<void>(url);
  }

  findByProduct(idProduct:number): Observable<Image[]>{
    const url = `${config['contentUrl']}/images/product/${idProduct}`;
    return this.http.get<ImageDto[]>(url).pipe(
      map((images)=>images.map(ImageMapper.toDomain)),
    );
  }

}
