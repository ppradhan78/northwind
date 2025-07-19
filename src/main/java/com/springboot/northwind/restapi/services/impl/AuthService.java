package com.springboot.northwind.restapi.services.impl;


import com.springboot.northwind.restapi.entity.User;
import com.springboot.northwind.restapi.repository.UserRepository;
import com.springboot.northwind.restapi.security.JwtSecurity;
import lombok.RequiredArgsConstructor;
//import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtSecurity jwtUtil;

    public String login(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if ( !password.equals( user.getPasswordHash())) {
//        if (!BCrypt.checkpw(password, user.getPasswordHash())) {
            throw new RuntimeException("Invalid password");
        }

        return jwtUtil.generateToken(username);
    }
}
