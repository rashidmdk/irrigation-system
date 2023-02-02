package com.irrigationsystem.config;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

@Configuration
public class AppConfig {

    private static final String timeFormat = "HH:mm:ss";

    private static void objectMapper(Jackson2ObjectMapperBuilder builder) {
        builder.simpleDateFormat(timeFormat);
    }

    @Bean
    public Jackson2ObjectMapperBuilderCustomizer jsonToObjectCustomizer() {
        return AppConfig::objectMapper;

    }
}
