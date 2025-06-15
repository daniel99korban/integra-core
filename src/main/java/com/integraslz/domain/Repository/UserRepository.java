package com.integraslz.domain.Repository;

import java.util.Optional;
import com.integraslz.domain.Entity.User;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    Optional<User> findByProviderIdAndProvider(String providerId, String provider);
    User save(User user);
}