import { Product } from "./product.model";

export class Category {
    id!: number;
    name!: string;
    products!: Product[];
    constructor(data:Partial<Category>){
      Object.assign(this,data);
    }

}
