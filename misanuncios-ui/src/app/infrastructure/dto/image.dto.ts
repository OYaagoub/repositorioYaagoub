import { ProductDto } from "./product.dto";

export interface ImageDto {
  id: number;
  path: string;
  product: ProductDto | null; // Assuming Product model exists

}
