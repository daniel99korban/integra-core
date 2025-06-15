package com.integraslz.infrastructure.persistence.User;

import java.util.UUID;

import jakarta.validation.constraints.Pattern;
import jakarta.persistence.*;
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
    
    @Column(name = "provider", nullable = false)
    @Pattern(regexp = "LOCAL|GOOGLE|FACEBOOK", message = "Provider inválido")
    private String provider;
    private String providerId;

    public UserEntity (UUID id, String name, String email, String provider, String providerId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.provider = provider;
        this.providerId = providerId;
    }

}
