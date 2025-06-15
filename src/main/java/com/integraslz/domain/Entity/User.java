package com.integraslz.domain.Entity;

import java.security.AuthProvider;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private UUID id;
    private String name;
    private String email;
    private AuthProvider provider; 
    private String providerId;
    
}
