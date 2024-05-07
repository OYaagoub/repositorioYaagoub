import { ProductDto } from "./product.dto";


export class CategoryDto {
    id!: number;
    name!: string;
    prodocts!: Set<ProductDto>;
    constructor(data:Partial<CategoryDto>){
      Object.assign(this,data);
    }

}
