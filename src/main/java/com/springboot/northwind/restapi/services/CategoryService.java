package com.springboot.northwind.restapi.services;

import com.springboot.northwind.restapi.entity.CategoryEntity;
import com.springboot.northwind.restapi.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    //add validation
    //osn BAL
    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryEntity> getAllCategories() {
       try
       {
           var result= categoryRepository.findAll();
           return result;
       }
       catch(Exception ex)
      {
          return null;
      }
    }

    public Optional<CategoryEntity> getCategoryById(Integer id) {
        var result= categoryRepository.findById(id);
        return  result;
    }

    public CategoryEntity createCategory(CategoryEntity category) {
        return categoryRepository.save(category);
    }
    public CategoryEntity updateCategory(CategoryEntity updatedCategory, Integer CategoryId) {

        CategoryEntity existing = categoryRepository.findById(CategoryId)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        existing.setCategoryName(updatedCategory.getCategoryName());
        existing.setDescription(updatedCategory.getDescription());


        return categoryRepository.save(existing);
    }

    public void deleteCategory(Integer id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found");
        }
        categoryRepository.deleteById(id);
    }
}
