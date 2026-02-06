package com.sequence.workout.model;

import com.sequence.workout.enums.SetType;
import com.sequence.workout.enums.WorkoutStatus;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "workout_sets")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class WorkoutSet {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_exercise_id", nullable = false)
    private WorkoutExercise workoutExercise;

    @Setter
    private Double weight;

    @Setter
    private Integer reps;

    private int orderIndex;

    @Enumerated(EnumType.STRING)
    private SetType type;

    @Setter
    @Column(nullable = false)
    private Boolean completed;

    @Builder
    public WorkoutSet(WorkoutExercise workoutExercise, Double weight, Integer reps, int orderIndex, SetType type, Boolean completed) {
        this.id = UUID.randomUUID();
        this.workoutExercise = workoutExercise;
        this.weight = weight;
        this.reps = reps;
        this.orderIndex = orderIndex;
        this.type = type;
        this.completed = completed;
    }
}
