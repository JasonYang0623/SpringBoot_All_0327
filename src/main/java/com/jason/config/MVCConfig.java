package com.jason.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Jason
 * @date 2023/3/29 11:09
 * @content
 */
@Configuration
public class MVCConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/index").setViewName("login");
        registry.addViewController("login.html").setViewName("login");
        registry.addViewController("/books/toAdd").setViewName("add");
    }
}
