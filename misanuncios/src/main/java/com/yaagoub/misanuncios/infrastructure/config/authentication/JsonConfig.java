package com.yaagoub.misanuncios.infrastructure.config.authentication;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class JsonConfig {

    @Bean
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper mapper = builder.createXmlMapper(false).build();
        // Customize the mapper to handle duplicate objects
        // Add other custom configurations as needed
        mapper.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        return mapper;
    }
}