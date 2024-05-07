import { ProductDto } from "./product.dto";

export interface ImageDto {
  id: number;
  path: string;
  product: ProductDto; // Assuming Product model exists
  
}
