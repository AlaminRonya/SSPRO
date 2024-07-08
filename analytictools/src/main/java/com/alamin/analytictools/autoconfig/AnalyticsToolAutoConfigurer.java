package com.alamin.analytictools.autoconfig;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(value = "com.alamin.analytictools.enable", havingValue = "true")
@ComponentScan(basePackages = "com.alamin.analytictools")
public class AnalyticsToolAutoConfigurer {
}
