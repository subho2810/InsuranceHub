package com.insurancehub.identity.service;

import com.insurancehub.identity.dto.request.LoginRequest;
import com.insurancehub.identity.dto.request.RegisterRequest;
import com.insurancehub.identity.dto.response.LoginResponse;
import com.insurancehub.identity.dto.response.RegisterResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}