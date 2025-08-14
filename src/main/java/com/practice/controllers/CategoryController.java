package com.practice.controllers;

import com.practice.dto.CategoryDto;
import com.practice.dto.CreateCategoryDto;
import com.practice.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        CategoryDto categoryDto = categoryService.createCategory(createCategoryDto);
        return new ResponseEntity<>(categoryDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categoryDtoList = categoryService.getAllCategories();
        return ResponseEntity.ok(categoryDtoList);
    }


}
