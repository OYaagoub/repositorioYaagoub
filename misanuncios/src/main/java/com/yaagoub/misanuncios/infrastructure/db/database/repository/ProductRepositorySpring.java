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
}
