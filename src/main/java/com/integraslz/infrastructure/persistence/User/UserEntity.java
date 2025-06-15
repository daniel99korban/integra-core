package com.integraslz.infrastructure.persistence.User;

import java.security.AuthProvider;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@Builder
@NoArgsConstructor
public class UserEntity {

    @Id
    private UUID id;
    private String name;
    private String email;
    
    @Enumerated(EnumType.STRING)
    private AuthProvider provider;
    private String providerId;

    public UserEntity (UUID id, String name, String email, AuthProvider provider, String providerId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.providerId = providerId;
    }

}
