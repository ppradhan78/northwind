package com.springboot.northwind.restapi.controllers.v1;

import com.springboot.northwind.restapi.entity.CategoryEntity;
import com.springboot.northwind.restapi.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
//@RequestMapping("/api/categories")
@RequestMapping("/api/v1/categories")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;
    @Value("${filepath}")
    private String filePath;
    @Value("${ApiKey}")
    private String ApiKey;
    @GetMapping("/List")
    public ResponseEntity<List<CategoryEntity>> getAllCategories() {
        var result=categoryService.getAllCategories();
        return ResponseEntity.ok(result);
    }

    @GetMapping("GetById/{id}")
    public ResponseEntity<CategoryEntity> getCategoryById(@PathVariable Integer id) {
        System.out.println("filePath"+filePath);
        System.out.println("ApiKey"+ ApiKey);
        var result=categoryService.getCategoryById(id);
        return result
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("Create")
    public CategoryEntity createCategory(@RequestBody CategoryEntity category) {
        return categoryService.createCategory(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryEntity> updateCategory(@PathVariable Integer id, @RequestBody CategoryEntity updatedCategory) {
        return ResponseEntity.ok(categoryService.updateCategory( updatedCategory,id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Integer id) {
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}
