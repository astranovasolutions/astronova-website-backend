package com.astronova.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI astronovaOpenAPI() {

        return new OpenAPI()
                .info(
                        new Info()
                                .title("Astronova Solutions API")
                                .version("1.0.0")
                                .description(
                                        "Backend APIs for Astronova Solutions Website and Admin Panel"
                                )
                                .contact(
                                        new Contact()
                                                .name("Manish Mahale")
                                                .email("admin@astronova.com")
                                )
                );
    }
}