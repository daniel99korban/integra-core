package com.integraslz.infrastructure.persistence.User;

import java.util.*;
import org.springframework.stereotype.Repository;

import com.integraslz.domain.Entity.User;
import com.integraslz.domain.Repository.UserRepository;

@Repository
public class UserJpaAdapter implements UserRepository {

    private final UserJpaRepository repository;

    public UserJpaAdapter(UserJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return repository.findByEmail(email).map(this::toDomain);
    }

    @Override
    public Optional<User> findByProviderIdAndProvider(String providerId, String provider) {
        return repository.findByProviderIdAndProvider(providerId, provider).map(this::toDomain);
    }

    @Override
    public User save(User user) {
        UserEntity entity = toEntity(user);
        return toDomain(repository.save(entity));
    }

    private UserEntity toEntity(User user) {
        return UserEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .provider(user.getProvider())
                .providerId(user.getProviderId())
                .build();
    }

    private User toDomain(UserEntity entity) {
        return new User(entity.getId(), 
                        entity.getName(), 
                        entity.getEmail(), 
                        entity.getProvider(), 
                        entity.getProviderId());
    }
}
