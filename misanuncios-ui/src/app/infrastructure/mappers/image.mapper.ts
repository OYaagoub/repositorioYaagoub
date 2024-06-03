import { ImageDto } from "../dto/image.dto";
import { Image } from "../../domain/model/image.model";
import { ProductMapper } from "./product.mapper";
export class ImageMapper {
  static toDomain(dto: ImageDto): Image {
    return {
      id: dto.id,
      path: dto.path,
      product: dto.product ? ProductMapper.toDomain(dto.product): null,


    };

  }
  static toDto(domain: Image): ImageDto {
    return {
      id: domain.id,
      path: domain.path,
      product:domain.product ? ProductMapper.toDto(domain.product) : null


    };

  }

}
