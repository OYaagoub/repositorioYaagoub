package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yaagoub.misanuncios.application.service.ProductService;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.ProductDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.ProductDtoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
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
public ResponseEntity<Object> getProducts(@RequestParam int page, @RequestParam int size) throws JsonProcessingException, JSONException {
    Pageable pageable = PageRequest.of(page, size);
    //Page<Product> productPage = (Page<Product>) productService.getAllProducts(pageable);
    //int totalPages = productPage.getTotalPages();
    var response = productService.getAllProducts(pageable).stream().map(product -> {
                return productDtoMapper.toDto(product,context);
            })
            .collect(Collectors.toList());
    //JSONObject globalResponse = new JSONObject();
    //globalResponse.put("products",response);
    //globalResponse.put("totalPages", totalPages);
    return ResponseEntity.ok().body(response);
  }
    @GetMapping("/products/search")
    public ResponseEntity<Object> getProductsBySearch(@RequestParam String query) throws JsonProcessingException, JSONException {
        //Pageable pageable = PageRequest.of(page, size);
        //Page<Product> productPage = (Page<Product>) productService.getAllProducts(pageable);
        //int totalPages = productPage.getTotalPages();
        var response = productService.getProductsBySearch(query).stream().map(product -> {
                    return productDtoMapper.toDto(product,context);
                })
                .collect(Collectors.toList());
        //JSONObject globalResponse = new JSONObject();
        //globalResponse.put("products",response);
        //globalResponse.put("totalPages", totalPages);
        return ResponseEntity.ok().body(response);
    }
    @GetMapping("/products/search/categories")
    public ResponseEntity<Object> getProductsByCategories(@RequestParam String query) throws JsonProcessingException {
        String[] queries = query.split(",");
        AtomicReference<List<ProductDto>> response = new AtomicReference<>();
        Arrays.stream(queries).forEach(s -> {
            List<ProductDto> productDtos= new ArrayList<>();
            productDtos = productService.getProductsByCategoryName(s).stream()
                    .map(product -> productDtoMapper.toDto(product,context))
                    .collect(Collectors.toList());
            List<ProductDto> finalProductDtos = productDtos;
            response.updateAndGet(current -> {
                if(current!=null){
                    current.addAll(finalProductDtos);
                }else{
                    return finalProductDtos;
                }

                return current;
            });
        });

        System.out.println(response.get());
        return ResponseEntity.ok().body(response.get());
    }
}
