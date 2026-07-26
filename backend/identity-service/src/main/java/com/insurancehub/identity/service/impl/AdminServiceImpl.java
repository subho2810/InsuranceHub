package com.insurancehub.identity.service.impl;

import com.insurancehub.identity.dto.response.UserSummaryResponse;
import com.insurancehub.identity.entity.User;
import com.insurancehub.identity.repository.UserRepository;
import com.insurancehub.identity.service.AdminService;
import com.insurancehub.identity.util.SortUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final UserRepository userRepository;

    @Override
    public Page<UserSummaryResponse> getAllUsers(
            int page,
            int size,
            String search,
            String sortBy,
            String direction
    ){

        sortBy = SortUtils.validateUserSortField(sortBy);

        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<User> users;

        if (search == null || search.isBlank()) {
            users = userRepository.findAll(pageable);
        } else {
            users = userRepository
                    .findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCaseOrEmailContainingIgnoreCase(
                            search,
                            search,
                            search,
                            pageable
                    );
        }

        return users.map(this::mapToUserSummary);
    }

    private UserSummaryResponse mapToUserSummary(User user) {

        return UserSummaryResponse.builder()
                .id(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .phoneNumber(user.getPhoneNumber())
                .role(user.getRole().getName())
                .enabled(user.getEnabled())
                .emailVerified(user.getEmailVerified())
                .build();
    }
}