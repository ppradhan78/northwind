package com.springboot.northwind.restapi.repository;

import com.springboot.northwind.restapi.entity.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findByUsername(String username);
}