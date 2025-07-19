package com.springboot.northwind.restapi.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.northwind.restapi.controllers.v1.CategoryController;
import com.springboot.northwind.restapi.dto.CategoryDTO;
import com.springboot.northwind.restapi.services.CategoryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CategoryController.class)
class CategoryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CategoryService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void getAllCategories_ShouldReturnListOfCategories() throws Exception {
        // Arrange
        CategoryDTO category1 = CategoryDTO.builder()
                .categoryId(1)
                .categoryName("Beverages")
                .build();

        CategoryDTO category2 = CategoryDTO.builder()
                .categoryId(2)
                .categoryName("Condiments")
                .build();

        List<CategoryDTO> categoryList = Arrays.asList(category1, category2);

        Mockito.when(service.getAllCategories()).thenReturn(categoryList);

        // Act & Assert
        mockMvc.perform(get("/api/categories"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].categoryId").value(1))
                .andExpect(jsonPath("$[0].categoryName").value("Beverages"))
                .andExpect(jsonPath("$[1].categoryId").value(2))
                .andExpect(jsonPath("$[1].categoryName").value("Condiments"));
    }
}
