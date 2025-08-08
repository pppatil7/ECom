package com.practice.services;

import com.practice.dto.CreateProductDto;
import com.practice.dto.ProductDetailsDto;

public interface ProductService {


    ProductDetailsDto createProduct(CreateProductDto createProductDto);

}
