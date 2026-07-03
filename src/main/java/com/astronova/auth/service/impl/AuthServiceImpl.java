package com.astronova.auth.service.impl;

import com.astronova.auth.dto.AuthResponse;
import com.astronova.auth.dto.LoginRequest;
import com.astronova.auth.dto.RegisterRequest;
import com.astronova.auth.service.AuthService;
import com.astronova.common.response.ApiResponse;
import com.astronova.exception.BadRequestException;
import com.astronova.exception.ResourceNotFoundException;
import com.astronova.role.entity.Role;
import com.astronova.role.enums.RoleType;
import com.astronova.role.repository.RoleRepository;
import com.astronova.security.JwtService;
import com.astronova.user.entity.User;
import com.astronova.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    @Override
    public ApiResponse<AuthResponse> register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new BadRequestException("Email already exists");
        }

        Role role = roleRepository
                .findByName(RoleType.ROLE_VIEWER)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Role not found"));

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .enabled(true)
                .role(role)
                .build();

        userRepository.save(user);

        String token = jwtService.generateToken(user.getEmail());

        return ApiResponse.<AuthResponse>builder()
                .success(true)
                .message("Registration successful")
                .data(
                        AuthResponse.builder()
                                .token(token)
                                .build()
                )
                .build();
    }

    @Override
    public ApiResponse<AuthResponse> login(LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        User user = userRepository
                .findByEmail(request.getEmail())
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        String token = jwtService.generateToken(user.getEmail());

        return ApiResponse.<AuthResponse>builder()
                .success(true)
                .message("Login successful")
                .data(
                        AuthResponse.builder()
                                .token(token)
                                .build()
                )
                .build();
    }

}