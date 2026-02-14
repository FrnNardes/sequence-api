package com.sequence.workout.model;

import com.sequence.user.model.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "routines")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Routine {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private String name;

    @OneToMany(mappedBy = "routine", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoutineExercise> exercises;

    @Builder
    public Routine(User user, String name, List<RoutineExercise> exercises) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.name = name;
        this.exercises = exercises;

    }
}
