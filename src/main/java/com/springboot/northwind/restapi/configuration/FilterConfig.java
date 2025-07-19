//package com.springboot.northwind.restapi.configuration;
//
//import com.springboot.northwind.restapi.Filter.JwtFilter;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class FilterConfig {
//
//    @Bean
//    public FilterRegistrationBean<JwtFilter> jwtFilter(JwtFilter jwtFilter) {
//        FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(jwtFilter);
//        registrationBean.addUrlPatterns("/api/protected/*");
//        return registrationBean;
//    }
//}
