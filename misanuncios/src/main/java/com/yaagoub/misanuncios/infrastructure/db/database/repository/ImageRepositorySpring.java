package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.application.repository.ImageRepository;
import com.yaagoub.misanuncios.domain.Image;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.ImageEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ImageRepositorySpring implements ImageRepository {

    private final SpringDataImageRepository springDataImageRepository;
    private final ImageEntityMapper imageEntityMapper;
    private final CycleAvoidingMappingContext context= new CycleAvoidingMappingContext();
    @Override
    public Iterable<Image> getImagesByProduct(long idProduct) {
        return springDataImageRepository.getImagesByProduct(idProduct).
                stream().map(image -> imageEntityMapper.toDomain(image,context))
                .collect(Collectors.toList());
    }

    @Override
    public Image save(Image image) {
        return imageEntityMapper.toDomain(springDataImageRepository
                .save(imageEntityMapper.toEntity(image,context)),context);
    }

    @Override
    public void delete(Image image) {
        springDataImageRepository.delete(imageEntityMapper.toEntity(image,context));
    }

    @Override
    public Image findById(long id) {
        return imageEntityMapper.toDomain(springDataImageRepository.findById(id),context);
    }
}
