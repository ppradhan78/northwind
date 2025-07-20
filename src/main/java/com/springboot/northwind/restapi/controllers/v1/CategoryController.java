package com.springboot.northwind.restapi.controllers.v1;

import com.springboot.northwind.restapi.dto.CategoryDTO;
import com.springboot.northwind.restapi.services.CategoryService;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import lombok.RequiredArgsConstructor;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService service;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<CategoryDTO> getAllCategories() {
        return service.getAllCategories();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getCategoryById(id));
    }

    @PostMapping
    public ResponseEntity<String> createCategory(@RequestBody CategoryDTO dto) {
        service.createCategory(dto);
        return ResponseEntity.ok("Category created successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Integer id, @RequestBody CategoryDTO dto) {
        service.updateCategory(id, dto);
        return ResponseEntity.ok("Category updated successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        service.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }
}

