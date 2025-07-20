//package com.springboot.northwind.restapi.configuration;
//
//import com.springboot.northwind.restapi.Filter.JwtFilter;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//public class SecurityConfig {
//    private final JwtFilter jwtFilter;
//
//    public SecurityConfig(JwtFilter jwtFilter) {
//        this.jwtFilter = jwtFilter;
//    }
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        return http.csrf(csrf -> csrf.disable())
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers(
//                                "/auth/**",                   // Allow login endpoint
//                                "/swagger-ui/**",             // Allow Swagger UI page and resources
//                                "/v3/api-docs/**",            // Allow OpenAPI docs
//                                "/swagger-resources/**",      // Allow Swagger resources
//                                "/webjars/**"                 // Allow static resources used by Swagger
//                        ).permitAll()                     // Allow without authentication
//                        .anyRequest().authenticated()    // Protect other APIs
//                )
//                .formLogin(form -> form.disable())   // Disable default login form
//                .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
//
//}
