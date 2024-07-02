package com.alamin.testdemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.DefaultCorsProcessor;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.handler.AbstractHandlerMapping;

import java.util.List;

@Configuration
public class ApplicationConfig {
//    DefaultCorsProcessor
//    AbstractHandlerMapping
    @Bean
    public CorsFilter corsFilter() { // This configuration is the filter-level
//        CorsFilter corsFilter = new CorsFilter(?);
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(List.of("http://localhost:3000", "http://localhost:4000"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/v1/**", config);
//        source.registerCorsConfiguration("/api/v2/**", config2);
        CorsFilter corsFilter = new CorsFilter(source);
        return corsFilter;
    }
}
