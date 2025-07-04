package com.springboot.northwind.restapi.services;
import com.springboot.northwind.restapi.entity.CategoryEntity;
import com.springboot.northwind.restapi.repository.CategoryRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    public void testGetAllCategories() {
        CategoryEntity category = new CategoryEntity();
        category.setCategoryID(1);
        category.setCategoryName("Beverages");
        List<CategoryEntity> mockCategories = Arrays.asList(category);

        when(categoryRepository.findAll()).thenReturn(mockCategories);

        List<CategoryEntity> result = categoryService.getAllCategories();

        assertEquals(1, result.size());
        assertEquals("Beverages", result.get(0).getCategoryName());
    }
}

