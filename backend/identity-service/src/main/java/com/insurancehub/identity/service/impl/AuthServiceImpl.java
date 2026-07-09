package com.insurancehub.identity.service.impl;

import com.insurancehub.identity.dto.request.RegisterRequest;
import com.insurancehub.identity.dto.response.RegisterResponse;
import com.insurancehub.identity.entity.Role;
import com.insurancehub.identity.entity.User;
import com.insurancehub.identity.exception.EmailAlreadyExistsException;
import com.insurancehub.identity.exception.PhoneNumberAlreadyExistsException;
import com.insurancehub.identity.repository.RoleRepository;
import com.insurancehub.identity.repository.UserRepository;
import com.insurancehub.identity.service.AuthService;
import com.insurancehub.identity.utils.RoleConstants;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

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
}