package com.yaagoub.misanuncios.application.repository;

import com.yaagoub.misanuncios.domain.Product;
import org.springframework.data.domain.Pageable;


public interface ProductRepository {
    Iterable<Product> getAllProducts(Pageable pageable);
    Iterable<Product> getProductsBySearch(String search);

    Iterable<Product> getProductsByCategoryName(String name);

    Iterable<Product> getProductsByUser(Long idUser);

    Product save(Product product);

    void delete(Product product);

    Product find(long idProduct);
}
