package com.joaodddev.authapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AuthApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuthApiApplication.class, args);
        System.out.println("\n" + "=".repeat(60));
        System.out.println("   🔐 AUTH API - SISTEMA DE AUTENTICAÇÃO JWT");
        System.out.println("=".repeat(60));
        System.out.println("✅ Aplicação iniciada com sucesso!");
        System.out.println("📡 Servidor: http://localhost:8080/api");
        System.out.println("📊 H2 Console: http://localhost:8080/api/h2-console");
        System.out.println("📝 Endpoint: POST /api/auth/register");
        System.out.println("📝 Endpoint: POST /api/auth/login");
        System.out.println("=".repeat(60));
    }
}
