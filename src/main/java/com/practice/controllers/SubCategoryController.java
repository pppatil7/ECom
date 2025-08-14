package com.practice.controllers;

import com.practice.dto.CreateSubCategoryDto;
import com.practice.dto.SubCategoryDto;
import com.practice.services.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class SubCategoryController {


    private final SubCategoryService subCategoryService;

    @PostMapping("/{categoryId}/subcategories")
    public ResponseEntity<SubCategoryDto> createSubCategory(@PathVariable Long categoryId, @RequestBody CreateSubCategoryDto createSubCategoryDto) {
        SubCategoryDto subCategoryDto = subCategoryService.createSubCategory(categoryId, createSubCategoryDto);
        return new ResponseEntity<>(subCategoryDto, HttpStatus.CREATED);
    }

    @GetMapping("/subcategories")
    public ResponseEntity<List<SubCategoryDto>> getAllSubCategories() {
        List<SubCategoryDto> subCategoryDtoList = subCategoryService.getAllSubCategories();
        return ResponseEntity.ok(subCategoryDtoList);
    }

}
