package com.astronova.auth.service;

import com.astronova.auth.dto.AuthResponse;
import com.astronova.auth.dto.LoginRequest;
import com.astronova.auth.dto.RegisterRequest;
import com.astronova.common.response.ApiResponse;

public interface AuthService {

    ApiResponse<AuthResponse> register(RegisterRequest request);

    ApiResponse<AuthResponse> login(LoginRequest request);
}
