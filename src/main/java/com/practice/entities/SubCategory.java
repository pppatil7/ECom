package com.practice.entities;

import jakarta.persistence.*;

@Entity
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long subCategoryId;

    private String subCategoryName;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
