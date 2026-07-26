package com.insurancehub.identity.service;

import com.insurancehub.identity.dto.response.UserSummaryResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface AdminService {

    Page<UserSummaryResponse> getAllUsers(
            int page,
            int size,
            String search,
            String sortBy,
            String direction
    );

}