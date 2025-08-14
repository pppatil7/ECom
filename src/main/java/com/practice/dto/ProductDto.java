package com.practice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {


    private String productId;

    private String productTitle;

    private String productBrandName;

    private Long productPrice;

    private Long subCategoryId;

    private String subCategoryName;


}
