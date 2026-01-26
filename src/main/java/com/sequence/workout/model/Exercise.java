package com.sequence.workout.model;

import com.sequence.workout.enums.ExerciseCategory;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "exercises")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Exercise {
    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(name = "target_muscle", nullable = false)
    private String targetMuscle;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ExerciseCategory category;
}
