package com.joaodddev.authapi.model;

public enum Role {
    USER("Usuário Comum"),
    ADMIN("Administrador"),
    MODERATOR("Moderador");

    private String description;

    Role(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
