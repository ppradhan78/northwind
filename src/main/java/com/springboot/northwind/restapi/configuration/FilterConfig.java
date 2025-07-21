package com.springboot.northwind.restapi.configuration;

import com.springboot.northwind.restapi.filter.JwtFilter;
import com.springboot.northwind.restapi.security.JwtSecurityService;
import com.springboot.northwind.restapi.security.JwtSecurityService;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public JwtFilter jwtFilter(JwtSecurityService jwtUtil) {
        return new JwtFilter(jwtUtil);   // ✅ Manual bean creation
    }

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterRegistration(JwtFilter jwtFilter) {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtFilter);
        registrationBean.addUrlPatterns("/api/categories/*");
//        registrationBean.addUrlPatterns(
//        "/swagger-ui/*",
//        "/v3/api-docs/*"
//    );
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
