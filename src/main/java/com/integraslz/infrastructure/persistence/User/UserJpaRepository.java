package com.integraslz.infrastructure.persistence.User;

import org.springframework.data.jpa.repository.JpaRepository;
import java.security.AuthProvider;
import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
    Optional<UserEntity> findByProviderIdAndProvider(String providerId, AuthProvider provider);
}
