package com.insurancehub.identity.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(
        name = "users",
        indexes = {
                @Index(name = "idx_user_email", columnList = "email"),
                @Index(name = "idx_user_phone", columnList = "phone_number")
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "phone_number", nullable = false, unique = true, length = 15)
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AccountStatus status;

    @Column(name = "email_verified", nullable = false)
    private Boolean emailVerified;

    @Column(nullable = false)
    private Boolean enabled;

    @Column(name = "account_non_locked", nullable = false)
    private Boolean accountNonLocked;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();

        if (status == null) {
            status = AccountStatus.PENDING_VERIFICATION;
        }

        if (emailVerified == null) {
            emailVerified = Boolean.FALSE;
        }

        if (enabled == null) {
            enabled = Boolean.TRUE;
        }

        if (accountNonLocked == null) {
            accountNonLocked = Boolean.TRUE;
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = LocalDateTime.now();
    }
}