package com.practice.services.impl;

import com.practice.dto.CategoryDto;
import com.practice.dto.CreateCategoryDto;
import com.practice.entities.Category;
import com.practice.repositories.CategoryRepository;
import com.practice.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CreateCategoryDto createCategoryDto) {
        Category category = modelMapper.map(createCategoryDto, Category.class);
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categoryList = categoryRepository.findAll();
        List<CategoryDto> categoryDtoList = new ArrayList<>();
        CategoryDto categoryDto;
        for (Category category : categoryList) {
            categoryDto = modelMapper.map(category, CategoryDto.class);
            categoryDtoList.add(categoryDto);
        }
        return categoryDtoList;
    }


}
