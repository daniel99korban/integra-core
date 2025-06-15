package com.integraslz.application.User;

import java.util.Optional;
import java.util.UUID;
import org.springframework.stereotype.Service;
import com.integraslz.domain.Entity.User;
import com.integraslz.domain.Repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findOrCreate(String name, String email, String provider, String providerId) {
        return userRepository.findByProviderIdAndProvider(providerId, provider)
                .orElseGet(() -> userRepository.save(new User(
                        UUID.randomUUID(),
                        name,
                        email,
                        provider,
                        providerId
                )));
    }

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
}
