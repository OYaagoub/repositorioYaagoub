import { ImageDto } from "../../infrastructure/dto/image.dto";
import { Image } from "../model/image.model";
import { ProductMapper } from "./product.mapper";
export class ImageMapper {
  static toDomain(dto: ImageDto): Image {
    return {
      id: dto.id,
      path: dto.path,
      product: ProductMapper.toDomain(dto.product)


    };

  }
  static toDto(domain: Image): ImageDto {
    return {
      id: domain.id,
      path: domain.path,
      product: ProductMapper.toDto(domain.product)


    };

  }

}
