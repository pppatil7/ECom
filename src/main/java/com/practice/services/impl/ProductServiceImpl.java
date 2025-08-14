package com.practice.services.impl;

import com.practice.dto.CreateProductDto;
import com.practice.dto.ProductDto;
import com.practice.entities.Product;
import com.practice.exceptions.ResourceNotFoundException;
import com.practice.repositories.ProductRepository;
import com.practice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(CreateProductDto createProductDto) {
        Product product = modelMapper.map(createProductDto, Product.class);
        Product savedProduct = productRepository.save(product);
        return modelMapper.map(savedProduct, ProductDto.class);
    }

    @Override
    public ProductDto updateProductByProductId(Long productId, CreateProductDto createProductDto) {
        Product product = productRepository.findById(productId).
                orElseThrow(() -> new ResourceNotFoundException("Product", "productId", String.valueOf(productId)));
        modelMapper.map(createProductDto, product);
        Product updatedProduct = productRepository.save(product);
        return modelMapper.map(updatedProduct, ProductDto.class);
    }

    @Override
    public ProductDto updatePartialProductByProductId(Long productId, Map<String, Object> updates) {
        Product product = productRepository.findById(productId).
                orElseThrow(() -> new ResourceNotFoundException("Product", "productId", String.valueOf(productId)));
        updates.forEach((field, value) -> {
            switch (field) {
                case "productTitle":
                    product.setProductTitle((String) value);
                    break;
                case "productPrice":
                    product.setProductPrice((Long) value);
                    break;
                default:
                    throw new IllegalArgumentException("Field is not Supported");
            }
        });
        Product updatedProduct = productRepository.save(product);
        return modelMapper.map(updatedProduct, ProductDto.class);
    }
}
