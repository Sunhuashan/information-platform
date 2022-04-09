package com.shs.bysj.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: shs
 * @Data: 2022/4/8 19:31
 */
@Configuration
public class MyWebConfiguration implements WebMvcConfigurer{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 将/api/file/** 访问映射到 E:/image/ 目录下
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "e:/image/");
    }
}
