package com.alamin.testdemo.config;

import com.alamin.testdemo.filters.MyLoggerFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfigFilter {
    @Bean
    public FilterRegistrationBean<MyLoggerFilter> filterRegistrationBean() {
        //Component r eta some kotha
//        FilterRegistrationBean<MyLoggerFilter> filterRegistrationBean = new FilterRegistrationBean<>();
//        filterRegistrationBean.setFilter(new MyLoggerFilter());
//        return filterRegistrationBean;
        FilterRegistrationBean<MyLoggerFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new MyLoggerFilter());
        filterRegistrationBean.setOrder(Integer.MIN_VALUE+1);
        filterRegistrationBean.addUrlPatterns("/api/v1/home/*");
        return filterRegistrationBean;
    }
}
