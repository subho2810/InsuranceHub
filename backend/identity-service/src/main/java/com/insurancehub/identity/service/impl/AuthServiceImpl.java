package com.insurancehub.identity.service.impl;

import com.insurancehub.identity.dto.request.LoginRequest;
import com.insurancehub.identity.dto.request.RegisterRequest;
import com.insurancehub.identity.dto.request.UpdateProfileRequest;
import com.insurancehub.identity.dto.response.LoginResponse;
import com.insurancehub.identity.dto.response.RegisterResponse;
import com.insurancehub.identity.dto.response.UserProfileResponse;
import com.insurancehub.identity.entity.Role;
import com.insurancehub.identity.entity.User;
import com.insurancehub.identity.exception.EmailAlreadyExistsException;
import com.insurancehub.identity.exception.PhoneNumberAlreadyExistsException;
import com.insurancehub.identity.repository.RoleRepository;
import com.insurancehub.identity.repository.UserRepository;
import com.insurancehub.identity.security.jwt.JwtProperties;
import com.insurancehub.identity.security.jwt.JwtService;
import com.insurancehub.identity.security.user.CustomUserDetails;
import com.insurancehub.identity.service.AuthService;
import com.insurancehub.identity.util.RoleConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final JwtProperties jwtProperties;

    @Override
    public RegisterResponse register(RegisterRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException(request.getEmail());
        }

        if (userRepository.existsByPhoneNumber(request.getPhoneNumber())) {
            throw new PhoneNumberAlreadyExistsException(request.getPhoneNumber());
        }

        Role customerRole = roleRepository.findByName(RoleConstants.CUSTOMER)
                .orElseThrow(() -> new IllegalStateException("Default CUSTOMER role not found"));

        User user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .phoneNumber(request.getPhoneNumber())
                .role(customerRole)
                .build();

        User savedUser = userRepository.save(user);

        return RegisterResponse.builder()
                .userId(savedUser.getId())
                .email(savedUser.getEmail())
                .message("User registered successfully")
                .build();
    }

    @Override
    public LoginResponse login(LoginRequest request) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );

        CustomUserDetails userDetails =
                (CustomUserDetails) authentication.getPrincipal();

        String token = jwtService.generateToken(userDetails.getUsername());

        return LoginResponse.builder()
                .accessToken(token)
                .tokenType("Bearer")
                .expiresIn(jwtProperties.getAccessTokenExpiration())
                .build();
    }

    @Override
    public UserProfileResponse getCurrentUser() {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        CustomUserDetails userDetails =
                (CustomUserDetails) authentication.getPrincipal();

        User user = userDetails.getUser();

        return mapToUserProfile(user);
    }


    @Override
    public UserProfileResponse updateProfile(UpdateProfileRequest request) {

        Authentication authentication =
                SecurityContextHolder.getContext().getAuthentication();

        CustomUserDetails userDetails =
                (CustomUserDetails) authentication.getPrincipal();

        User user = userDetails.getUser();

        if (!user.getPhoneNumber().equals(request.getPhoneNumber())
                && userRepository.existsByPhoneNumber(request.getPhoneNumber())) {

            throw new PhoneNumberAlreadyExistsException(request.getPhoneNumber());
        }

        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setPhoneNumber(request.getPhoneNumber());

        User updatedUser = userRepository.save(user);

        return mapToUserProfile(user);
    }


    private UserProfileResponse mapToUserProfile(User user) {
        return UserProfileResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole().getName())
                .emailVerified(user.getEmailVerified())
                .build();
    }
}