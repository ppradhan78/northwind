package com.springboot.northwind.restapi.repository;
import com.springboot.northwind.restapi.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Integer> {

//Custom method can add
}