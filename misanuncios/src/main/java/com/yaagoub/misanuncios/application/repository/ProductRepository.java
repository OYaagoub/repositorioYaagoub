package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Product;
import org.springframework.data.domain.Pageable;


public interface ProductRepository {
    Iterable<Product> getAllProducts(Pageable pageable);
}
