package com.springboot.northwind.restapi.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Category {
    private int categoryId;
    private String categoryName;
    private String description;
    private byte[] picture;
}
