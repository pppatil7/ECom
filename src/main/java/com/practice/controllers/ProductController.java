package com.practice.controllers;

import com.practice.dto.CreateProductDto;
import com.practice.dto.ProductDto;
import com.practice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class ProductController {


    private final ProductService productService;

    @PostMapping("categories/{categoryId}/subcategories/{subCategoryId}/products")
    public ResponseEntity<ProductDto> createProduct(@PathVariable Long categoryId, @PathVariable Long subCategoryId, @RequestBody CreateProductDto createProductDto) {
        ProductDto productDto = productService.createProduct(categoryId, subCategoryId, createProductDto);
        return new ResponseEntity<>(productDto, HttpStatus.CREATED);
    }

    @PutMapping("/{productId}")
    public ResponseEntity<ProductDto> updateProductByProductId(@PathVariable Long productId,
                                                               @RequestBody CreateProductDto createProductDto) {
        ProductDto productDto = productService.updateProductByProductId(productId, createProductDto);
        return ResponseEntity.ok(productDto);
    }

    @PatchMapping("/{productId}")
    public ResponseEntity<ProductDto> updatePartialProductByProductId(@PathVariable Long productId,
                                                                      @RequestBody Map<String, Object> updates) {
        ProductDto productDto = productService.updatePartialProductByProductId(productId, updates);
        return ResponseEntity.ok(productDto);
    }

}
