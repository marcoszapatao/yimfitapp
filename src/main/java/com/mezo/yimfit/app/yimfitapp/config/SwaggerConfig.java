package com.mezo.yimfit.app.yimfitapp.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {

    @Bean
    GroupedOpenApi publicApi(){
        return GroupedOpenApi.builder()
                .group("public-api")
                .pathsToMatch("/api/**")
                .build();
    }

    @Bean
    OpenAPI customOpenApi(){
        return new OpenAPI()
                .info(new Info()
                        .title("YimfitApp API")
                        .version("1.0.0")
                        .description("API para la gestión de reservas de clases de CrossFit y seguimiento inteligente")
                        .termsOfService("http://swagger.io/terms/")
                        .contact(new Contact()
                                .name("Soporte YimfitApp")
                                .url("http://www.yimfitapp.com/support")
                                .email("support@yimfitapp.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("http://springdoc.org")));
    }
}
