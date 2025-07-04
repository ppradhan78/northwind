package com.springboot.northwind.restapi.controllers;

import com.springboot.northwind.restapi.controllers.v1.CategoryController;
import com.springboot.northwind.restapi.entity.CategoryEntity;
import com.springboot.northwind.restapi.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryControllerTest {

    @Mock
    private CategoryService categoryService;

    @InjectMocks
    private CategoryController categoryController;

    @Test
    public void testGetAllCategories() {

        CategoryEntity category = new CategoryEntity();
        category.setCategoryID(1);
        category.setCategoryName("Beverages");
        List<CategoryEntity> categories = Arrays.asList(category);
        when(categoryService.getAllCategories()).thenReturn(categories);

        ResponseEntity<List<CategoryEntity>> response = categoryController.getAllCategories();
        assertEquals(200, response.getStatusCode().value());
        assertEquals(1, response.getBody().size());
        assertEquals("Beverages", response.getBody().get(0).getCategoryName());
    }
}
