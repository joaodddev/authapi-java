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
        System.out.println("📚 Swagger: http://localhost:8080/api/swagger-ui.html");
        System.out.println("\n📋 Endpoints:");
        System.out.println("   POST /api/auth/register - Registrar novo usuário");
        System.out.println("   POST /api/auth/login    - Fazer login");
        System.out.println("   POST /api/auth/refresh  - Renovar token");
        System.out.println("\n📝 Exemplo de registro:");
        System.out.println("   curl -X POST http://localhost:8080/api/auth/register \\");
        System.out.println("     -H \"Content-Type: application/json\" \\");
        System.out.println(
                "     -d '{\"fullName\":\"João Silva\",\"email\":\"joao@email.com\",\"password\":\"123456\"}'");
        System.out.println("=".repeat(60));
    }
}
