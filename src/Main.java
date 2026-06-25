package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class Main {

    public static void main(String[] args) {
        // FIX: Changed from DemoApplication.class to Main.class
        SpringApplication.run(Main.class, args);
    }

    @GetMapping("/")
    public String hello() {
        return "Hello from DevOps CI/CD Pipeline 10";
    }
}
