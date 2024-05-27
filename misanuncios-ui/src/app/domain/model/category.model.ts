import { Product } from "./product.model";

export class Category {
    id!: number;
    name!: string;
    products!: Product[] | null;
    constructor(data:Partial<Category>){
      Object.assign(this,data);
    }

}
