package com.alamin.InterceptorDemo.config;

import com.alamin.InterceptorDemo.interceptor.AnalyticsInterceptor;
import com.alamin.InterceptorDemo.interceptor.SimpleInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@RequiredArgsConstructor
public class InterceptorConfig implements WebMvcConfigurer {
    private final SimpleInterceptor simpleInterceptor;
    private final AnalyticsInterceptor analyticsInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(simpleInterceptor).addPathPatterns("/**");
        registry.addInterceptor(analyticsInterceptor).addPathPatterns("/**");
    }
}
