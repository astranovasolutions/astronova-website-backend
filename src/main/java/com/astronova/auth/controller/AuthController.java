package com.astronova.auth.controller;

import com.astronova.auth.dto.AuthResponse;
import com.astronova.auth.dto.LoginRequest;
import com.astronova.auth.dto.RegisterRequest;
import com.astronova.auth.service.AuthService;
import com.astronova.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Tag(
        name = "Authentication",
        description = "Authentication APIs"
)
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @Operation(
            summary = "Register User",
            description = "Creates a new user account"
    )
    @PostMapping("/register")
    public ApiResponse<AuthResponse> register(
            @Valid @RequestBody RegisterRequest request) {

        return authService.register(request);
    }

    @Operation(
            summary = "Login User",
            description = "Authenticates user and returns JWT"
    )
    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return authService.login(request);
    }

    @GetMapping("/me")
    public Map<String, Object> me(Authentication authentication) {

        Map<String, Object> response = new HashMap<>();

        response.put("email", authentication.getName());
        response.put("authorities", authentication.getAuthorities());

        return response;
    }

}
