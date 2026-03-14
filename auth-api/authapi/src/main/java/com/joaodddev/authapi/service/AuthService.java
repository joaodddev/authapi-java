package com.joaodddev.authapi.service;

import com.joaodddev.authapi.dto.AuthResponseDTO;
import com.joaodddev.authapi.dto.LoginRequestDTO;
import com.joaodddev.authapi.dto.RegisterRequestDTO;
import com.joaodddev.authapi.model.Role;
import com.joaodddev.authapi.model.User;
import com.joaodddev.authapi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    private final AuthenticationManager authenticationManager;

    @Transactional
    public AuthResponseDTO register(RegisterRequestDTO request) {
        // Verificar se email já existe
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email já cadastrado");
        }

        // Criar novo usuário
        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phone(request.getPhone())
                .role(Role.USER)
                .build();

        user = userRepository.save(user);

        // Gerar tokens
        String jwtToken = tokenService.generateToken(user);
        String refreshToken = tokenService.generateRefreshToken(user);

        return buildAuthResponse(user, jwtToken, refreshToken);
    }

    public AuthResponseDTO login(LoginRequestDTO request) {
        // Autenticar usuário
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        // Buscar usuário
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        // Gerar novos tokens
        String jwtToken = tokenService.generateToken(user);
        String refreshToken = tokenService.generateRefreshToken(user);

        return buildAuthResponse(user, jwtToken, refreshToken);
    }

    public AuthResponseDTO refreshToken(String authHeader) {
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new RuntimeException("Token inválido");
        }

        String refreshToken = authHeader.substring(7);
        String userEmail = tokenService.extractUsername(refreshToken);

        if (userEmail == null) {
            throw new RuntimeException("Token inválido");
        }

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

        if (!tokenService.isTokenValid(refreshToken, user)) {
            throw new RuntimeException("Token expirado ou inválido");
        }

        String newToken = tokenService.generateToken(user);
        String newRefreshToken = tokenService.generateRefreshToken(user);

        return buildAuthResponse(user, newToken, newRefreshToken);
    }

    private AuthResponseDTO buildAuthResponse(User user, String token, String refreshToken) {
        return AuthResponseDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .fullName(user.getFullName())
                .role(user.getRole())
                .token(token)
                .refreshToken(refreshToken)
                .tokenType("Bearer")
                .expiresIn(System.currentTimeMillis() + 86400000) // 24 horas em millis (fixo)
                .build();
    }
}
