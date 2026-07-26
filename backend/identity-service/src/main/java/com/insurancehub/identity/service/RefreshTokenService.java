package com.insurancehub.identity.service;

import com.insurancehub.identity.entity.RefreshToken;
import com.insurancehub.identity.entity.User;

import java.util.UUID;

public interface RefreshTokenService {

    RefreshToken createRefreshToken(User user);

    RefreshToken findByToken(String token);

    RefreshToken verifyExpiration(RefreshToken refreshToken);

    void revokeAllUserTokens(UUID userId);

    RefreshToken updateLastUsed(RefreshToken refreshToken);

    void revokeToken(String token);

}