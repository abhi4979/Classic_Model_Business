package com.springboot.main_pkg.config;

import java.util.Arrays;
import java.util.List;

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
@OpenAPIDefinition(info=@io.swagger.v3.oas.annotations.info.Info(title="Android",description="This is mine",summary="Api contains summary info",termsOfService = "Terms&ConditionApplied..."
         ,contact= @Contact(name="DeveloperAbhi"
                    ,email="Abhisek.gmail.com"
         ),
         license = @License(name="Abhisek Pradhan"),
         version="Api/v1"  
		),
   servers = {
		   @io.swagger.v3.oas.annotations.servers.Server(description="localhost",url="http://localhost:8099")
   },
   security= @io.swagger.v3.oas.annotations.security.SecurityRequirement(name="androidSecurity")
)

@io.swagger.v3.oas.annotations.security.SecurityScheme(name="androidSecurity",
in=SecuritySchemeIn.HEADER,
type =SecuritySchemeType.HTTP,
bearerFormat = "JWT",
scheme="bearer",
description = "This is my basic security"
		)
public class SwaggerConfig {

    @Bean
   public OpenAPI myCustomConfig() {
        // Add Security Scheme for Authorization Header
       SecurityScheme securityScheme = new SecurityScheme()
                .name("Authorization")
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT"); // Optional for clarity
        
        SecurityRequirement securityRequirement = new SecurityRequirement()
                .addList("Authorization");

       return new OpenAPI()
                .info(
                        new Info()
                                .title("Customer Controller")
                                .description("By Abhisek"))
                .addServersItem(new Server().url("http://localhost:8099").description("local"))
                .addServersItem(new Server().url("http://localhost:8089").description("live"))
                .tags(Arrays.asList(
                        new Tag().name("Customer-API"),
                        new Tag().name("Employee API"),
                        new Tag().name("Office API"),
                        new Tag().name("ProductLines API"),
                        new Tag().name("Product API")
                        ))
               .components(new Components().addSecuritySchemes("Authorization", securityScheme)) // Register the scheme
              .addSecurityItem(securityRequirement); // Apply security globally
               
    }

}

