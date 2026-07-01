package com.astronova.auth.service;

import com.astronova.auth.dto.AuthResponse;
import com.astronova.auth.dto.LoginRequest;
import com.astronova.auth.dto.RegisterRequest;

public interface AuthService {

    AuthResponse register(RegisterRequest request);

    AuthResponse login(LoginRequest request);
}
