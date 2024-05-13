package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yaagoub.misanuncios.application.service.CategoryService;
import com.yaagoub.misanuncios.application.service.ProductService;
import com.yaagoub.misanuncios.infrastructure.db.database.mapper.ProductEntityMapper;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CategoryDtoMapper;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.ProductDtoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v3/content")
@CrossOrigin("*")
@AllArgsConstructor
public class ProductController {
private ProductService productService;
private ProductDtoMapper productDtoMapper;
private final CycleAvoidingMappingContext context= new CycleAvoidingMappingContext();
@GetMapping("/products")
public ResponseEntity<Object> getProducts(@RequestParam int page, @RequestParam int size) throws JsonProcessingException {
    Pageable pageable = PageRequest.of(page, size);
    var response = productService.getAllProducts(pageable).stream().map(product -> {
                return productDtoMapper.toDto(product,context);
            })
            .collect(Collectors.toList());

    return ResponseEntity.ok().body(response);
  }



}
