package com.insurancehub.identity.service.impl;

import com.insurancehub.identity.entity.RefreshToken;
import com.insurancehub.identity.entity.User;
import com.insurancehub.identity.repository.RefreshTokenRepository;
import com.insurancehub.identity.security.jwt.JwtProperties;
import com.insurancehub.identity.service.RefreshTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenServiceImpl implements RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    private final JwtProperties jwtProperties;

    @Override
    public RefreshToken createRefreshToken(User user) {

        RefreshToken refreshToken = RefreshToken.builder()
                .token(UUID.randomUUID().toString())
                .user(user)
                .expiryDate(
                        LocalDateTime.now().plus(
                                Duration.ofMillis(
                                        jwtProperties.getRefreshTokenExpiration()
                                )
                        )
                )
                .revoked(false)
                .createdAt(LocalDateTime.now())
                .lastUsedAt(LocalDateTime.now())
                .build();

        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public RefreshToken findByToken(String token) {
        return refreshTokenRepository.findByToken(token)
                .orElseThrow(() ->
                        new IllegalArgumentException("Refresh token not found"));
    }

    @Override
    public RefreshToken verifyExpiration(RefreshToken refreshToken) {
        if (refreshToken.getExpiryDate().isBefore(LocalDateTime.now())) {

            refreshToken.setRevoked(true);

            refreshTokenRepository.save(refreshToken);

            throw new IllegalArgumentException("Refresh token has expired");
        }

        return refreshToken;
    }

    @Override
    public void revokeAllUserTokens(UUID userId) {

    }

    @Override
    public RefreshToken updateLastUsed(RefreshToken refreshToken) {

        refreshToken.setLastUsedAt(LocalDateTime.now());

        return refreshTokenRepository.save(refreshToken);
    }

    @Override
    public void revokeToken(String token) {

        Optional<RefreshToken> optionalToken =
                refreshTokenRepository.findByToken(token);

        if (optionalToken.isEmpty()) {
            return;
        }

        RefreshToken refreshToken = optionalToken.get();

        if (Boolean.TRUE.equals(refreshToken.getRevoked())) {
            return;
        }

        refreshToken.setRevoked(true);
        refreshToken.setLastUsedAt(LocalDateTime.now());

        refreshTokenRepository.save(refreshToken);
    }


}