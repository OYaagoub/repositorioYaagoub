package com.yaagoub.misanuncios.infrastructure.rest.spring.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import io.swagger.v3.oas.models.OpenAPI;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.info.Info;
@Configuration
@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                title = "Misanuncios API",
                version = "1.0",
                description = "API documentation for the Misanuncios application"
        ),
        servers = @Server(url = "/", description = "Default Server URL")
)
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi contentApi() {
        return GroupedOpenApi.builder()
                .group("com.yaagoub.misanuncios.infrastructure.rest.spring.controllers")
                .packagesToScan("com.yaagoub.misanuncios.infrastructure.rest.spring.controllers")
                .pathsToMatch("/api/v3/content/**")
                .build();
    }
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Misanuncios API")
                        .version("1.0")
                        .description("API documentation for Misanuncios application"));
    }
}
