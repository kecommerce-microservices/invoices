package com.devkit.invoices.infrastructure.configurations;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.devkit.invoices.infrastructure.configurations.json.Json;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;

@JsonComponent
public class ObjectMapperConfig {

    @Bean
    public ObjectMapper mapper() {
        return Json.mapper();
    }
}
