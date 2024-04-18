package com.example.project.config;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Ulukbek",
                        email = "utoraliev@gmail.com"
                ),
                description = "This API provides endpoints for managing tours, including listing tours by continent, retrieving popular tours, and getting recommended tours for different seasons.",
                title = "Tour Management API",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://www.google.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "https://localhost:8080"
                ),
        }
)
public class OpenApiConfig {
}
