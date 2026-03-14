package com.joaodddev.authapi.dto;

import com.joaodddev.authapi.model.Role;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthResponseDTO {
    private Long id;
    private String email;
    private String fullName;
    private Role role;
    private String token;
    private String refreshToken;
    private String tokenType;
    private long expiresIn;
}
