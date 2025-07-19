package com.springboot.northwind.restapi.configuration;

import com.springboot.northwind.restapi.Filter.JwtFilter;
import com.springboot.northwind.restapi.security.JwtSecurity;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public JwtFilter jwtFilter(JwtSecurity jwtUtil) {
        return new JwtFilter(jwtUtil);   // ✅ Manual bean creation
    }

    @Bean
    public FilterRegistrationBean<JwtFilter> jwtFilterRegistration(JwtFilter jwtFilter) {
        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(jwtFilter);
        registrationBean.addUrlPatterns("/api/categories/*");
        registrationBean.setOrder(1);
        return registrationBean;
    }
}
