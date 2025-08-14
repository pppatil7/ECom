package com.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SubCategoryDto {

    private Long subCategoryId;

    private String subCategoryName;

    private Long categoryId;

    private String categoryName;
}
