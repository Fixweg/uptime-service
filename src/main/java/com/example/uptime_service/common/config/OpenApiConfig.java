package com.example.uptime_service.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI uptimeServiceApi() {
        return new OpenAPI().info(new Info()
                .title("Uptime Service API")
                .description("Verwaltung und Überwachung von Monitoren")
                .version("v1"));
    }
}
