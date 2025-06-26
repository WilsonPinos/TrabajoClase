package org.example.trabajoclase.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.Contact;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI trabajoClaseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sistema de Facturación API")
                        .description("API RESTful para el sistema de facturación")
                        .version("v1.0.0")
                        .contact(new Contact()
                                .name("TrabajoClase")
                                .email("info@trabajoclase.com")));
    }
}
