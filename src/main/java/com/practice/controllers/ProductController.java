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
@RequestMapping("/products")
public class ProductController {


    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody CreateProductDto createProductDto) {
        ProductDto productDto = productService.createProduct(createProductDto);
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
