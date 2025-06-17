package com.integraslz.api;

import java.util.Optional;

import org.springframework.web.bind.annotation.*;
import com.integraslz.application.User.UserService;
import com.integraslz.domain.Entity.User;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/by-email")
    public Optional<User> findByEmail(@RequestParam String email) {
        return service.findByEmail(email);
    }

    @PostMapping("/register")
    public User register(@RequestBody @Valid User user) {
        return service.findOrCreate(
                user.getName(),
                user.getEmail(),
                user.getProvider(),
                user.getProviderId()
        );
    }
}
