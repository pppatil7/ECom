package com.practice.services;

import com.practice.dto.CreateProductDto;
import com.practice.dto.ProductDto;

import java.util.Map;

public interface ProductService {


    ProductDto createProduct(CreateProductDto createProductDto);

    ProductDto updateProductByProductId(Long productId, CreateProductDto createProductDto);

    ProductDto updatePartialProductByProductId(Long productId, Map<String, Object> updates);

}
