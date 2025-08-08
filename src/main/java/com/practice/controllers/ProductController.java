package com.practice.controllers;

import com.practice.dto.CreateProductDto;
import com.practice.dto.ProductDto;
import com.practice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
