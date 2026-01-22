package com.sequence.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class User {
    @Id
    private UUID id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @JsonIgnore
    @Column(nullable = false)
    private String password;

    @Column(name = "created_at", updatable = false)
    private OffsetDateTime createdAt;

    @Builder
    public User(String username, String email, String password){
        if(!email.contains("@")){
            throw new IllegalArgumentException("Invalid email format");
        }
        this.id = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = OffsetDateTime.now();
    }
}
