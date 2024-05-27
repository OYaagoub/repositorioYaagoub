package com.yaagoub.misanuncios.infrastructure.rest.spring.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.yaagoub.misanuncios.application.service.CategoryService;
import com.yaagoub.misanuncios.application.service.RoleService;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CategoryDtoMapper;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.CycleAvoidingMappingContext;
import com.yaagoub.misanuncios.infrastructure.rest.spring.mapper.RoleDtoMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping("/api/v3/content")
@CrossOrigin("*")
@AllArgsConstructor
public class CategoryController {
private CategoryService categoryService;
private CategoryDtoMapper categoryDtoMapper;
private final CycleAvoidingMappingContext context= new CycleAvoidingMappingContext();
@GetMapping("/categories")
public ResponseEntity<Object> getCategories() throws JsonProcessingException {
    var response = categoryService.getAllCategories().stream().map(category -> {

                return categoryDtoMapper.toDto(category,context);
            })
            .collect(Collectors.toList());
    return ResponseEntity.ok().body(response);
  }
    @GetMapping("/categories/name")
    public ResponseEntity<Object> getCategoriesByName() throws JsonProcessingException {
        var response = categoryService.getAllCategoriesByName();
        return ResponseEntity.ok().body(response);
    }




}
