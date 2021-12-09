package com.aaa.edu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 全局配置类-配置跨域请求
 */
@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
//                .allowedOrigins("http://192.168.43.159:8080",null)
//                .allowedOrigins("http://localhost:8080",null)
//                .allowedOrigins("http://localhost:9528",null)
                .allowedOrigins("http://localhost:9528","http://localhost:9529")
                .allowedMethods("GET","POST","PUT","DELETE","OPTIONS")
                .allowCredentials(true).maxAge(3600);
    }
}
