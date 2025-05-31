package com.springboot.main_pkg.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.tags.Tag;

@Configuration
@OpenAPIDefinition(
    info = @io.swagger.v3.oas.annotations.info.Info(
        title = "Android",
        description = "This is mine",
        summary = "Api contains summary info",
        termsOfService = "Terms&ConditionApplied...",
        contact = @Contact(
            name = "DeveloperAbhi",
            email = "Abhisek.gmail.com"
        ),
        license = @License(name = "Abhisek Pradhan"),
        version = "Api/v1"
    ),
    servers = {
        @io.swagger.v3.oas.annotations.servers.Server(description = "live", url = "https://classical-model-business.onrender.com")
    },
    security = @io.swagger.v3.oas.annotations.security.SecurityRequirement(name = "androidSecurity")
)
@io.swagger.v3.oas.annotations.security.SecurityScheme(
    name = "androidSecurity",
    in = SecuritySchemeIn.HEADER,
    type = SecuritySchemeType.HTTP,
    bearerFormat = "JWT",
    scheme = "bearer",
    description = "This is my basic security"
)
public class SwaggerConfig {

    @Bean
    public OpenAPI myCustomConfig() {
        SecurityScheme securityScheme = new SecurityScheme()
            .name("Authorization")
            .type(SecurityScheme.Type.HTTP)
            .scheme("bearer")
            .bearerFormat("JWT");

        SecurityRequirement securityRequirement = new SecurityRequirement()
            .addList("androidSecurity");  // <-- Use "androidSecurity" here

        return new OpenAPI()
            .info(new Info()
                .title("Customer Controller")
                .description("By Abhisek"))
            .addServersItem(new Server().url("https://classical-model-business.onrender.com").description("Production"))
            
            .tags(Arrays.asList(
                new Tag().name("Customer-API"),
                new Tag().name("Employee API"),
                new Tag().name("Office API"),
                new Tag().name("ProductLines API"),
                new Tag().name("Product API")
            ))
            .components(new Components().addSecuritySchemes("androidSecurity", securityScheme))  // <-- Same name here
            .addSecurityItem(securityRequirement);
    }
}
