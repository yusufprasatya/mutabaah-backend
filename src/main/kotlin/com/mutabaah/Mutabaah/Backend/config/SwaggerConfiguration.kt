package com.mutabaah.Mutabaah.Backend.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.License

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfiguration {
    @Bean
    fun apiInfo(): OpenAPI {
        return OpenAPI().info(
            Info().title("Mutabaah Backend")
                .description("This API developed in springboot kotlin. ")
                .version("v1")
        )
    }
}