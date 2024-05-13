import { ProductDto } from "./product.dto";


export interface CategoryDto {
    id: number;
    name: string;
    products: ProductDto[];
    //prodocts!: ProductDto[];

}
