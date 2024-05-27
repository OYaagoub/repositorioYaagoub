import { Observable } from "rxjs";
import { Image } from "../../domain/model/image.model";




export abstract class ImageRepository {
    abstract save(image: Image): Observable<Image>;
    abstract delete(id: string): void;
    abstract findByProduct(idProduct:number): Observable<Image[]>;
}
