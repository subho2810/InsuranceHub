package com.insurancehub.identity.service;

import com.insurancehub.identity.dto.request.*;
import com.insurancehub.identity.dto.response.LoginResponse;
import com.insurancehub.identity.dto.response.RegisterResponse;
import com.insurancehub.identity.dto.response.UserProfileResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

    UserProfileResponse getCurrentUser();

    UserProfileResponse updateProfile(UpdateProfileRequest request);

    LoginResponse refreshAccessToken(RefreshTokenRequest request);

    void logout(LogoutRequest request);

}