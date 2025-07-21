package com.springboot.northwind.restapi.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RequestInterceptor implements HandlerInterceptor {
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_RESET = "\u001B[0m";
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(ANSI_BLUE +"########################################################################"+ ANSI_RESET);
        System.out.println(ANSI_BLUE +"Incoming Request: " + request.getMethod() + " " + request.getRequestURI()+ ANSI_RESET);
        System.out.println(ANSI_BLUE +"########################################################################"+ ANSI_RESET);

        // Example: Block a specific IP or path
        // if (request.getRemoteAddr().equals("192.168.1.10")) {
        //     response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        //     return false;
        // }

        return true; // Continue request processing
    }
}
