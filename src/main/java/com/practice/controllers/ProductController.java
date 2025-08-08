package com.practice.controllers;

import com.practice.dto.CreateProductDto;
import com.practice.dto.ProductDetailsDto;
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
    public ResponseEntity<ProductDetailsDto> createProduct(@RequestBody CreateProductDto createProductDto) {
        ProductDetailsDto productDetailsDto = productService.createProduct(createProductDto);
        return new ResponseEntity<>(productDetailsDto, HttpStatus.CREATED);
    }

}
