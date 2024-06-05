import { CategoryDto } from "../dto/category.dto";
import { Category } from "../../domain/model/category.model";
import { ProductMapper } from "./product.mapper";
export class CategoryMapper {
  static toDomain(dto: CategoryDto): Category {
    return {
      id: dto.id,
      name:dto.name,
      products: dto.products ? dto.products.map(ProductMapper.toDomain) : null,



    };

  }
  static toDto(domain: Category): CategoryDto {
    return {
      id: domain.id,
      name:domain.name,
      products: domain.products ? domain.products.map(ProductMapper.toDto) : null,



    };

  }

}
