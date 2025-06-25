package com.example.kfc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**") // 또는 "/**" 전체 허용
                        .allowedOrigins("http://localhost:5173", "http://84.247.155.23", "https://kfcfootball.club", "https://www.kfcfootball.club")
                        .allowedMethods("*")
                        .allowedHeaders("*").allowCredentials(true); // 로그인/쿠키 등 사용할 경우 필수
            }
        };
    }
}
