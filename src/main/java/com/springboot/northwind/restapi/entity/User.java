package com.springboot.northwind.restapi.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Integer userId;
    private String username;
    private String passwordHash;
    private String email;
    private String phoneNumber;
    private String role;
}
