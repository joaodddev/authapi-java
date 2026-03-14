package com.joaodddev.authapi.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/public")
    public String publicEndpoint() {
        return "Este é um endpoint público!";
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('USER')")
    public String userEndpoint() {
        return "Este é um endpoint para USUÁRIOS autenticados!";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('ADMIN')")
    public String adminEndpoint() {
        return "Este é um endpoint para ADMINISTRADORES!";
    }

    @GetMapping("/moderator")
    @PreAuthorize("hasAuthority('MODERATOR')")
    public String moderatorEndpoint() {
        return "Este é um endpoint para MODERADORES!";
    }
}
