package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.application.repository.ProductRepository;
import com.yaagoub.misanuncios.domain.Product;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CategoryEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.ProductEntityMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class ProductRepositorySpring implements ProductRepository {
    private final CycleAvoidingMappingContext context=new CycleAvoidingMappingContext();
    private final ProductEntityMapper productEntityMapper;
    private final SpringDataProductRepository springDataProductRepository;
    @Override
    public Iterable<Product> getAllProducts(Pageable pageable) {
        return springDataProductRepository.findAll(pageable).stream().map(
                productEntity -> {
                    return productEntityMapper.toDomain(productEntity,context);
                }
        ).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> getProductsBySearch(String search) {
        return springDataProductRepository.findAllBySearch(search).stream().map(
                productEntity -> {
                    return productEntityMapper.toDomain(productEntity,context);
                }
        ).collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> getProductsByCategoryName(String name) {
        return springDataProductRepository.getProductsByCategoryName(name).stream()
                .map(productEntity -> productEntityMapper.toDomain(productEntity,context))
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> getProductsByUser(Long idUser) {
        return springDataProductRepository.getProductsEntityByUser(idUser).stream()
                .map(productEntity -> productEntityMapper.toDomain(productEntity,context))
                .collect(Collectors.toList());
    }

    @Override
    public Product save(Product product) {
        return productEntityMapper.toDomain(springDataProductRepository.save(productEntityMapper.toEntity(product,context)),context);
    }

    @Override
    public void delete(Product product) {
        springDataProductRepository.delete(productEntityMapper.toEntity(product,context));
    }

    @Override
    public Product find(long idProduct) {
        return productEntityMapper.toDomain(springDataProductRepository.getReferenceById(idProduct),context);
    }
}
