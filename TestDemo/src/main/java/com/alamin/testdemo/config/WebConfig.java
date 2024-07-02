package com.alamin.testdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) { // This apply is the handler-interceptor-level
        registry.addMapping("/api/v1/**")
                .allowedOrigins("http://localhost:3000")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .exposedHeaders("custom-header","custom-value")
                .allowCredentials(true)
                .maxAge(3600);
        registry.addMapping("/api/v2/**")
                .allowedOrigins("http://localhost:4000")
                .allowedMethods("GET");
    }
}
