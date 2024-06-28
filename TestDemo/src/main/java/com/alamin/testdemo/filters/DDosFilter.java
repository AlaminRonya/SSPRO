package com.alamin.testdemo.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.core.ApplicationFilterChain;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@Order(Integer.MIN_VALUE)
@Component
@EnableScheduling
public class DDosFilter implements Filter {
//    ApplicationFilterChain
    private final ConcurrentMap<String, AtomicInteger> map = new ConcurrentHashMap<>();
    private static final int MAX_REQ = 10;

    @Scheduled(fixedRate = 10_000)
    public void cleanUp(){
        if(!map.isEmpty()){
            map.clear();
        }
    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("-----------------------before ddos filter------------------------");
        /*
        1.Step
         */
//        filterChain.doFilter(servletRequest, servletResponse);
        /*
        2.Step
         */
//        HttpServletResponse response = (HttpServletResponse) servletResponse;
//        response.setStatus(HttpStatus.UNAUTHORIZED.value());
//        response.getWriter().write("You can not access!");
//        System.out.println("-----------------------after ddos filter------------------------");
        /*
        3.Step
         */
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        var ip = request.getRemoteAddr();
        var count = map.computeIfAbsent(ip, k -> new AtomicInteger());
        if (count.incrementAndGet() > MAX_REQ) {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            response.setContentType("application/json");
            response.getWriter().write(
                    Map.of(
                            "message", "I know, you are a hacker bro! "
                    ).toString()
            );
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
