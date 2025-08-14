package com.practice.dto;

import com.practice.entities.SubCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {

    private Long categoryId;

    private String categoryName;

    private List<SubCategory> subCategories;


}
