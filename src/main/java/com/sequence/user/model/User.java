package com.sequence.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sequence.pathway.model.Pathway;
import com.sequence.pathway.model.Sequence;
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pathway_id")
    private Pathway pathway;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_sequence_id")
    private Sequence currentSequence;

    @Column(name = "current_xp")
    private Integer currentXp = 0;

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
        this.currentXp = 0;
    }

    public void choosePathway(Pathway pathway, Sequence startingSequence) {
        this.pathway = pathway;
        this.currentSequence = startingSequence;
        this.currentXp = 0;
    }
}
