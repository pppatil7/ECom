package com.practice.services.impl;

import com.practice.dto.CreateSubCategoryDto;
import com.practice.dto.SubCategoryDto;
import com.practice.entities.Category;
import com.practice.entities.SubCategory;
import com.practice.exceptions.ResourceNotFoundException;
import com.practice.repositories.CategoryRepository;
import com.practice.repositories.SubCategoryRepository;
import com.practice.services.SubCategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubCategoryService {

    private final CategoryRepository categoryRepository;

    private final SubCategoryRepository subCategoryRepository;

    private final ModelMapper modelMapper;

    @Override
    public SubCategoryDto createSubCategory(Long categoryId, CreateSubCategoryDto createSubCategoryDto) {
        Category category = categoryRepository.findById(categoryId).
                orElseThrow(() -> new ResourceNotFoundException("Category", "categoryId", String.valueOf(categoryId)));
        SubCategory subCategory = modelMapper.map(createSubCategoryDto, SubCategory.class);
        subCategory.setCategory(category);
        SubCategory savedSubCategory = subCategoryRepository.save(subCategory);
        return modelMapper.map(savedSubCategory, SubCategoryDto.class);
    }

    @Override
    public List<SubCategoryDto> getAllSubCategories() {
        return List.of();
    }
}
