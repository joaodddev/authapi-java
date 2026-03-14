# 🔐 Auth API - Sistema de Autenticação com JWT

![Java](https://img.shields.io/badge/Java-21+-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.11-brightgreen)
![JWT](https://img.shields.io/badge/JWT-JSON%20Web%20Tokens-blue)

## 📋 Sobre o Projeto

API REST completa para autenticação de usuários utilizando **Spring Boot** e **JWT**. Este projeto serve como base para qualquer sistema que necessite de controle de acesso e autenticação segura.

### 🎯 Funcionalidades

- ✅ **Registro de novos usuários** com validação de email único
- ✅ **Login** com geração de token JWT
- ✅ **Refresh token** para renovar sessão sem novo login
- ✅ **Proteção de rotas** com Spring Security
- ✅ **Criptografia de senhas** com BCrypt
- ✅ **Validações** com Bean Validation
- ✅ **Tratamento global de erros**
- ✅ **Documentação automática** com OpenAPI/Swagger

## 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão | Descrição |
|------------|--------|-----------|
| Java | 21 | Linguagem de programação |
| Spring Boot | 3.5.11 | Framework principal |
| Spring Security | 6.x | Autenticação e autorização |
| JWT | 0.12.6 | Tokens de acesso |
| JPA/Hibernate | - | Persistência de dados |
| H2 Database | - | Banco de dados em memória |
| Lombok | - | Redução de código boilerplate |
| Maven | - | Gerenciamento de dependências |

## 📁 Estrutura do Projeto
authapi/
├── src/
│ └── main/
│ ├── java/com/joaodddev/authapi/
│ │ ├── AuthApiApplication.java
│ │ ├── config/
│ │ │ ├── SecurityConfig.java
│ │ │ └── JwtAuthenticationFilter.java
│ │ ├── controller/
│ │ │ └── AuthController.java
│ │ ├── dto/
│ │ │ ├── AuthResponseDTO.java
│ │ │ ├── ErrorResponseDTO.java
│ │ │ ├── LoginRequestDTO.java
│ │ │ └── RegisterRequestDTO.java
│ │ ├── exception/
│ │ │ └── GlobalExceptionHandler.java
│ │ ├── model/
│ │ │ ├── Role.java
│ │ │ └── User.java
│ │ ├── repository/
│ │ │ └── UserRepository.java
│ │ └── service/
│ │ ├── AuthService.java
│ │ ├── CustomUserDetailsService.java
│ │ └── TokenService.java
│ └── resources/
│ └── application.properties
├── .gitignore
├── pom.xml
└── README.md

## 🚀 Como Executar

### Pré-requisitos

- Java 21 ou superior
- Maven 3.9+ (ou usar o wrapper `./mvnw`)
- Git (opcional)

### Passo a passo

1. **Clone o repositório**
   ```bash
   git clone https://github.com/joaodddev/authapi-java.git
   cd authapi-java
2. **Compile o projeto**
   ```bash
   ./mvnw clean package
3. **Execute a aplicação**
   ```bash
   ./mvnw spring-boot:run
4. Acesse os endpoints
   API Base: http://localhost:8080/api
   H2 Console: http://localhost:8080/api/h2-console
   Swagger UI: http://localhost:8080/api/swagger-ui.html

# 👨‍💻 Autor | João Victor
https://img.shields.io/badge/GitHub-joaodddev-181717?style=flat&logo=github
https://img.shields.io/badge/LinkedIn-Perfil-0077B5?style=flat&logo=linkedin
