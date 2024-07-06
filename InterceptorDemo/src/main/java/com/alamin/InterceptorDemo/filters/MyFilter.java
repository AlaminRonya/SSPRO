package com.alamin.InterceptorDemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * Filter-level does not resolve to controller information.
 * Interceptor-level resolves to the controller information
 * Lifecycle caught to the filter-level
 * Lifecycle did not catch to the HandlerInterceptor-level but handle to the level is the data passing way
 */
@Component
@Slf4j
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long startTime = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        long endTime = System.currentTimeMillis();
        log.info("Filter execution time: {} ms", (endTime - startTime));
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
