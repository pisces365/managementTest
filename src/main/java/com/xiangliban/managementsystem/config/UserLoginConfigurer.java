package com.xiangliban.managementsystem.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration      //加入配置
@SpringBootConfiguration
public class UserLoginConfigurer implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //设置访问项目外文件路径
        registry.addResourceHandler("/api/file/**").addResourceLocations("file:" + "./img/");
    }

}
