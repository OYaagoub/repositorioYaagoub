package com.yaagoub.misanuncios.application.service;

import com.yaagoub.misanuncios.application.repository.CategoryRepository;
import com.yaagoub.misanuncios.domain.Category;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return (List<Category>) categoryRepository.getAllCategories();
    };
    public List<String> getAllCategoriesByName(){
        return (List<String>) categoryRepository.getAllCategoriesByName();
    }

}
