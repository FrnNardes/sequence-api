package com.sequence.workout.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "routine_exercises")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RoutineExercise {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id", nullable = false)
    private Routine routine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exercise_id", nullable = false)
    private Exercise exercise;

    @Column(name = "order_index", nullable = false)
    private int orderIndex;

    @OneToMany(mappedBy = "routineExercise", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<RoutineSet> sets;

    @Builder
    public RoutineExercise(Routine routine, Exercise exercise, int orderIndex, List<RoutineSet> sets) {
        this.id = UUID.randomUUID();
        this.routine = routine;
        this.exercise = exercise;
        this.orderIndex = orderIndex;
        this.sets = sets != null ? sets : new ArrayList<>();
    }
}
