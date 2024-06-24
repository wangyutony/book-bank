package com.harbada.bookbank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Book bank project",
                version = "1.0.0",
                description = "Tony's book bank project",
                termsOfService = "terms",
                contact = @Contact(name = "Tony")
        )
)
public class BookBankApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookBankApplication.class, args);
    }
}
