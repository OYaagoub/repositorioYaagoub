import { Observable } from "rxjs";
import { Image } from "../../domain/model/image.model";




export abstract class ImageRepository {
    abstract save(image:string,product_id:number): Observable<Image>;
    abstract delete(id: number): Observable<boolean>;
    abstract findByProduct(idProduct:number): Observable<Image[]>;
}
