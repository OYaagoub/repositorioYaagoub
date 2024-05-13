import { CategoryDto } from "../../infrastructure/dto/category.dto";
import { ImageDto } from "../../infrastructure/dto/image.dto";
import { Category } from "../model/category.model";
import { Image } from "../model/image.model";
import { ProductMapper } from "./product.mapper";
export class CategoryMapper {
  static toDomain(dto: CategoryDto): Category {
    return {
      id: dto.id,
      name:dto.name,
      products: dto.products.map(ProductMapper.toDomain),



    };

  }
  static toDto(domain: Category): CategoryDto {
    return {
      id: domain.id,
      name:domain.name,
      products: domain.products.map(ProductMapper.toDto),



    };

  }

}
