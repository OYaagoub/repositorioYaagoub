package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yaagoub.misanuncios.application.service.CategoryService;
import com.yaagoub.misanuncios.application.service.ProductService;
import com.yaagoub.misanuncios.application.service.UserService;
import com.yaagoub.misanuncios.domain.Product;
import com.yaagoub.misanuncios.domain.User;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.ProductDto;
import com.yaagoub.misanuncios.infrastructure.rest.spring.dto.views.Views;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.ProductDtoMapper;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.UserDtoMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v3/content")
@CrossOrigin("*")
@AllArgsConstructor
@Tag(name = "Product Controller", description = "CRUD operations for Product ")
public class ProductController {
private final ProductService productService;
private final ProductDtoMapper productDtoMapper;
private final CategoryService categoryService;
private final UserService userService;
private final UserDtoMapper userDtoMapper;
private final CycleAvoidingMappingContext context= new CycleAvoidingMappingContext();
@JsonView({Views.ProductSample.class})
@GetMapping("/products")
public ResponseEntity<Object> getProducts(@RequestParam int page, @RequestParam int size) throws JsonProcessingException {
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
    @JsonView({Views.ProductSample.class})
    @GetMapping("/products/search")
    public ResponseEntity<Object> getProductsBySearch(@RequestParam String query) throws JsonProcessingException {
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
    @JsonView({Views.ProductSample.class})
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

    @JsonView(Views.ProductSample.class)
    @GetMapping("/products/mine")
    public ResponseEntity<Object> getProductsByUser() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(MapperFeature.DEFAULT_VIEW_INCLUSION);


        if(getAuthentication() instanceof User user){
            var response = productService.getProductsByUser(user.getId()).stream().
                    map(product -> productDtoMapper.toDto(product,context));



            return ResponseEntity.ok().body(response);

        }else{
            return ResponseEntity.ok().body("Authentication request");
        }
    }
    @JsonView(Views.ProductSample.class)
    @PostMapping("/products/new")
    public ResponseEntity<Object> saveProduct(@RequestBody ProductDto productDto){
        System.out.println(productDto);
        if(this.getAuthentication() instanceof User user){
            Product product= productDtoMapper.toDomain(productDto,context);
            product.setUser(user);
            product.setCategory(categoryService.findByName(productDto.getCategory().getName()));
           return ResponseEntity.ok().body(productDtoMapper.toDto(productService.save(product),context));

        }else {
            return ResponseEntity.ok().body("Authentication request");
        }
    }

    @JsonView({Views.ProductSample.class})
    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getProductById(@PathVariable long id){
        Product product = productService.find(id);
        System.out.println(product);
        return  ResponseEntity.ok().body(productDtoMapper.toDto(product,context));
    }
    @DeleteMapping("/products/delete/{idProduct}")
    public ResponseEntity<Object> deleteProduct(@PathVariable long idProduct) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> data = new HashMap<>();


        if(this.getAuthentication() instanceof User user){
            Product product = productService.find(idProduct);
            if(product!=null && product.getUser().getId()==user.getId()){

                productService.delete(product);
                data.put("description","Product deleted");
                data.put("status",true);
            }else {
                data.put("description","Product not deleted (not existed or trying to delete product not yours )");
                data.put("status",false);
            }

        }else {
            data.put("description","Authentication request");
            data.put("status",false);

        }

            // Convert Map to JSON
            String json = mapper.writeValueAsString(data);
        return ResponseEntity.ok().body(json);


    }


    Object getAuthentication(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getPrincipal();
    }

}
