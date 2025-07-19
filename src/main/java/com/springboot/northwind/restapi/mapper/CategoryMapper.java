package com.springboot.northwind.restapi.mapper;

import com.springboot.northwind.restapi.dto.CategoryDTO;
import com.springboot.northwind.restapi.entity.Category;
import com.springboot.northwind.restapi.model.CategoryModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryDTO toDto(CategoryModel model);

    CategoryModel toModel(CategoryDTO dto);

    CategoryModel entityToModel(Category entity);

    Category modelToEntity(CategoryModel model);
}
