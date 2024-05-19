package com.yaagoub.misanuncios.application.service;

import com.yaagoub.misanuncios.application.repository.CategoryRepository;
import com.yaagoub.misanuncios.application.repository.ProductRepository;
import com.yaagoub.misanuncios.domain.Category;
import com.yaagoub.misanuncios.domain.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getAllProducts(Pageable pageable){
        return (List<Product>) productRepository.getAllProducts(pageable);
    };
    public List<Product> getProductsBySearch(String search){
        return (List<Product>) productRepository.getProductsBySearch(search);
    };
    public  List<Product> getProductsByCategoryName(String name){
        return (List<Product>) productRepository.getProductsByCategoryName(name);
    }
}
