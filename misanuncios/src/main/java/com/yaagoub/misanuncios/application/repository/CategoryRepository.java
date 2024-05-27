package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Category;

public interface CategoryRepository {
    Iterable<Category> getAllCategories();
    Iterable<String> getAllCategoriesByName();

    Category findByName(String name);

}
