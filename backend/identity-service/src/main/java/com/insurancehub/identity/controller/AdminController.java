package com.insurancehub.identity.controller;

import com.insurancehub.identity.dto.response.UserSummaryResponse;
import com.insurancehub.identity.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
@RequiredArgsConstructor
public class AdminController {

    private final AdminService adminService;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ADMIN')")
    public Page<UserSummaryResponse> getAllUsers(

            @RequestParam(defaultValue = "0") int page,

            @RequestParam(defaultValue = "10") int size,

            @RequestParam(required = false) String search,

            @RequestParam(defaultValue = "firstName") String sortBy,

            @RequestParam(defaultValue = "asc") String direction) {

        return adminService.getAllUsers(
                page,
                size,
                search,
                sortBy,
                direction
        );
    }
}