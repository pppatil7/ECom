package com.practice.services;

import com.practice.dto.CategoryDto;
import com.practice.dto.CreateCategoryDto;

public interface CategoryService {

    CategoryDto createCategory(CreateCategoryDto createCategoryDto);

}
