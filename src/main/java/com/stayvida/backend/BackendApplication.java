package com.stayvida.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BackendApplication {


    public static void main(String[] args) {    

        // Load environment variables from .env file
        // This is optional if you are using dotenv-spring-boot
        // If you are using dotenv-spring-boot, it will automatically load the .env
        // file at startup, so you don't need to do this manually.
        // Dotenv dotenv = Dotenv.load();
        io.github.cdimascio.dotenv.Dotenv dotenv = io.github.cdimascio.dotenv.Dotenv.configure()
                .ignoreIfMissing()
                .load();

        dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

        SpringApplication.run(BackendApplication.class, args);
    }
}

