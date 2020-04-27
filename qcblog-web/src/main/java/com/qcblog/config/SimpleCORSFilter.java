package com.qcblog.config;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 处理跨域
 */
@Component
public class SimpleCORSFilter extends OncePerRequestFilter {
    @Override
    public void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {
        String origin = request.getHeader("Origin");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, origin);
        response.setHeader(HttpHeaders.ACCESS_CONTROL_EXPOSE_HEADERS, "x-auth-token");
        // 预检请求
        if (HttpMethod.OPTIONS.matches(request.getMethod())) {
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS,
                    "Origin, X-Requested-With, Content-Type, Accept, x-auth-token");
            response.setHeader(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS,
                    "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS, TRACE");
            response.setHeader(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "86400");
            return;
        }

        filterChain.doFilter(request, response);
    }
}
