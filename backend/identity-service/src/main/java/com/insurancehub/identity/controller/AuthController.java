package com.insurancehub.identity.controller;

import com.insurancehub.identity.dto.request.LoginRequest;
import com.insurancehub.identity.dto.request.RegisterRequest;
import com.insurancehub.identity.dto.request.UpdateProfileRequest;
import com.insurancehub.identity.dto.response.LoginResponse;
import com.insurancehub.identity.dto.response.RegisterResponse;
import com.insurancehub.identity.dto.response.UserProfileResponse;
import com.insurancehub.identity.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public RegisterResponse register(@Valid @RequestBody RegisterRequest request) {
        return authService.register(request);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(
            @Valid @RequestBody LoginRequest request) {

        return ResponseEntity.ok(authService.login(request));
    }

    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getCurrentUser() {
        return ResponseEntity.ok(authService.getCurrentUser());
    }

    @PutMapping("/profile")
    public ResponseEntity<UserProfileResponse> updateProfile(
            @Valid @RequestBody UpdateProfileRequest request) {

        return ResponseEntity.ok(authService.updateProfile(request));
    }
}