import { ProductDto } from "../dto/product.dto";
import { Product } from "../../domain/model/product.model";
import { CategoryMapper } from "./category.mapper";
import { ImageMapper } from "./image.mapper";
import { UserMapper } from "./user.mapper";

export class ProductMapper{
  static toDomain(dto: ProductDto) : Product{
    return{
      id:dto.id,
      title: dto.title,
      description: dto.description,
      user:dto.user ? UserMapper.toDto(dto.user) : null ,
      price: dto.price,
      category :dto.category ? CategoryMapper.toDomain(dto.category) : null,
      images: dto.images ? dto.images.map(image => ImageMapper.toDomain(image)) : [],


    };

  }
  static toDto(domain: Product) : ProductDto{
    return{
      id:domain.id,
      title: domain.title,
      description: domain.description,
      user: domain.user ? UserMapper.toDto(domain.user) : null ,
      price: domain.price,
      category :domain.category ? CategoryMapper.toDto(domain.category) : null,
      images: domain.images ? domain.images.map(image => ImageMapper.toDto(image)) : [],


    };

  }

}
