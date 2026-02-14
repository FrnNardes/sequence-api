package com.sequence.workout.model;

import com.sequence.user.model.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "workout_exercises")
@NoArgsConstructor
@Getter
public class WorkoutExercise {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "workout_id", nullable = false)
    private Workout workout;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @OneToMany(mappedBy = "workoutExercise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkoutSet> sets;

    @Column(name = "order_index", nullable = false)
    private int orderIndex;

    @Builder
    public WorkoutExercise(Workout workout, Exercise exercise, List<WorkoutSet> sets, int orderIndex) {
        this.id = UUID.randomUUID();
        this.workout = workout;
        this.exercise = exercise;
        this.sets = sets != null ? sets : new ArrayList<>();
        this.orderIndex = orderIndex;
    }
}

