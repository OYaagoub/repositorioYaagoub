import { Product } from "./product.model";

export class Image {
  id!: number;
  path!: string;
  product!: Product | null; // Assuming Product model exists
  constructor(data:Partial<Image>){
    Object.assign(this, data);
  }
}
