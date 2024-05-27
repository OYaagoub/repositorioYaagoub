import { ProductDto } from "../dto/product.dto";
import { Product } from "../../domain/model/product.model";
import { User } from "../../domain/model/user.model";
import { CategoryMapper } from "./category.mapper";
import { ConversationMapper } from "./conversation.mapper";
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
      category :dto.categoryDto ? CategoryMapper.toDomain(dto.categoryDto) : null,


    };

  }
  static toDto(domain: Product) : ProductDto{
    return{
      id:domain.id,
      title: domain.title,
      description: domain.description,
      user: domain.user ? UserMapper.toDto(domain.user) : null ,
      price: domain.price,
      categoryDto :domain.category ? CategoryMapper.toDto(domain.category) : null,


    };

  }

}
