package com.integraslz.infrastructure.persistence.User;

import java.util.UUID;

import jakarta.validation.constraints.*;
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
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private UUID id;

    @NotBlank
    @NotNull
    private String name;

    @NotBlank
    @NotNull
    @Email
    private String email;
    
    @Column(name = "provider", nullable = false)
    @Pattern(regexp = "LOCAL|GOOGLE|FACEBOOK", message = "Provider inválido")
    private String provider;
    private String providerId;

}
