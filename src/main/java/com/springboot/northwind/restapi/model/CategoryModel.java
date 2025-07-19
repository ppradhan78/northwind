package com.springboot.northwind.restapi.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryModel {
    private int categoryId;
    private String categoryName;
    private String description;
    private byte[] picture;

}
