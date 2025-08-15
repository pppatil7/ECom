package com.practice.services.impl;

import com.practice.dto.CreateProductDto;
import com.practice.dto.ProductDto;
import com.practice.entities.Product;
import com.practice.entities.SubCategory;
import com.practice.exceptions.ResourceNotFoundException;
import com.practice.repositories.ProductRepository;
import com.practice.repositories.SubCategoryRepository;
import com.practice.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final SubCategoryRepository subCategoryRepository;

    private final ModelMapper modelMapper;

    @Override
    public ProductDto createProduct(Long categoryId, Long subCategoryId, CreateProductDto createProductDto) {
        SubCategory subCategory = subCategoryRepository.findById(subCategoryId).
                orElseThrow(() -> new ResourceNotFoundException("SubCategory", "subCategoryId", String.valueOf(subCategoryId)));
        if (!subCategory.getCategory().getCategoryId().equals(categoryId)) {
            throw new IllegalArgumentException(
                    "SubCategory with id " + subCategoryId + " does not belong to Category with id " + categoryId
            );
        }
        Product product = modelMapper.map(createProductDto, Product.class);
        product.setSubCategory(subCategory);
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
                case "productBrandName":
                    product.setProductBrandName((String) value);
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
