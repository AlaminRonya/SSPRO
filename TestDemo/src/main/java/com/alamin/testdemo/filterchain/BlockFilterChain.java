package com.alamin.testdemo.filterchain;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class BlockFilterChain extends OncePerRequestFilter {
    private final List<Filter> filters = List.of(
            new ThreadLoggerFilter(),
            new IPLoggerFilter(),
            new TimeLoggerFilter()
    );
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        CustomVirtualFilterChain customVirtualFilterChain = new CustomVirtualFilterChain(filterChain);
        customVirtualFilterChain.doFilter(request, response);
    }
    private class CustomVirtualFilterChain implements FilterChain {
        private final FilterChain originalChain;
        private int currentPosition = 0;
        private CustomVirtualFilterChain(FilterChain originalChain) {
            this.originalChain = originalChain;
        }

        @Override
        public void doFilter(ServletRequest request, ServletResponse response) throws IOException, ServletException {
            if (currentPosition == filters.size()) {
                originalChain.doFilter(request, response);
            }else {
                currentPosition++;
                filters.get(currentPosition - 1).doFilter(request, response, this);
//                filters.get(currentPosition - 1).doFilter(request, response, currentChain);
            }
        }
    }
}
