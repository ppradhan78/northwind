package com.springboot.northwind.restapi.Filter;

import com.springboot.northwind.restapi.security.JwtSecurity;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class JwtFilter extends OncePerRequestFilter {

    private final JwtSecurity jwtUtil;

    public JwtFilter(JwtSecurity jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
    @Override
    protected boolean shouldNotFilter(HttpServletRequest request) {
        String path = request.getRequestURI();
        return path.startsWith("/swagger-ui/")
                || path.startsWith("/v3/api-docs")
                || path.startsWith("/swagger-resources")
                || path.startsWith("/webjars/")
                || path.startsWith("/auth/");
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String authHeader = request.getHeader("Authorization");
        String username = null;
        String role = null;
        String email = null;
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            username = jwtUtil.extractUsername(token);
            if (jwtUtil.validateToken(token)) {
                 username = jwtUtil.extractUsername(token);
                 role = jwtUtil.extractRole(token);

                List<SimpleGrantedAuthority> authorities =
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + role));

                UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(username, null, authorities);
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
            if (!jwtUtil.validateToken(token)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Invalid token");
                return;
            }
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Missing token");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
