package com.yaagoub.misanuncios.infrastructure.db.database.repository;

import com.yaagoub.misanuncios.application.repository.CategoryRepository;
import com.yaagoub.misanuncios.domain.Category;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CategoryEntityMapper;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.CycleAvoidingMappingContext;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Slf4j
@Repository
@RequiredArgsConstructor
public class CategoryRepositorySpring implements CategoryRepository {
    private final SpringDataCategoryRepository springDataCategoryRepository;
    private final CategoryEntityMapper categoryEntityMapper;
    private final CycleAvoidingMappingContext context = new CycleAvoidingMappingContext();

    @Override
    public Iterable<Category> getAllCategories() {

        return springDataCategoryRepository.findAll().stream().map(categoryEntity ->
                categoryEntityMapper.toDomain(categoryEntity,context)).collect(Collectors.toList());
    }

    @Override
    public Iterable<String> getAllCategoriesByName() {
        return springDataCategoryRepository.getAllCategoriesByName();
    }
}
