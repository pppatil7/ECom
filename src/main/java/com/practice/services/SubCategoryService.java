package com.practice.services;

import com.practice.dto.CreateSubCategoryDto;
import com.practice.dto.SubCategoryDto;

import java.util.List;

public interface SubCategoryService {

    SubCategoryDto createSubCategory(Long categoryId, CreateSubCategoryDto createSubCategoryDto);

    List<SubCategoryDto> getAllSubCategories();


}
