package com.springboot.northwind.restapi.services.impl;

import com.springboot.northwind.restapi.dto.CategoryDTO;
import com.springboot.northwind.restapi.entity.Category;
import com.springboot.northwind.restapi.mapper.CategoryMapper;
import com.springboot.northwind.restapi.model.CategoryModel;
import com.springboot.northwind.restapi.repository.CategoryRepository;
import com.springboot.northwind.restapi.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository repository;
    private final CategoryMapper categoryMapper;

    @Override
    public List<CategoryDTO> getAllCategories() {
        return repository.findAll().stream()
                .map(categoryMapper::entityToModel)
                .map(categoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDTO getCategoryById(Integer id) {
        return repository.findById(id)
                .map(categoryMapper::entityToModel)
                .map(categoryMapper::toDto)
                .orElseThrow(() -> new RuntimeException("Category not found with id " + id));
    }

    @Override
    public void createCategory(CategoryDTO dto) {
        CategoryModel model = categoryMapper.toModel(dto);
        Category entity = categoryMapper.modelToEntity(model);
        repository.save(entity);
    }

    @Override
    public void updateCategory(Integer id, CategoryDTO dto) {
        dto.setCategoryId(id);
        CategoryModel model = categoryMapper.toModel(dto);
        Category entity = categoryMapper.modelToEntity(model);
        repository.update(entity);
    }

    @Override
    public void deleteCategory(Integer id) {
        repository.deleteById(id);
    }
}
