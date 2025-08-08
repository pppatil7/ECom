package com.practice.services.impl;

import com.practice.dto.CreateProductDto;
import com.practice.dto.ProductDetailsDto;
import com.practice.entities.Product;
import com.practice.repositories.ProductRepository;
import com.practice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Override
    public ProductDetailsDto createProduct(CreateProductDto createProductDto) {
        Product product = modelMapper.map(createProductDto, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDetailsDto.class);
    }
}
