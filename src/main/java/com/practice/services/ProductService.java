package com.practice.services;

import com.practice.dto.CreateProductDto;
import com.practice.dto.ProductDto;

public interface ProductService {


    ProductDto createProduct(CreateProductDto createProductDto);

}
