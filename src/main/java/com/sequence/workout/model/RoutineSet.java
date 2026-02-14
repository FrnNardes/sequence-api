package com.sequence.workout.model;

import com.sequence.workout.enums.SetType;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "routine_sets")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class RoutineSet {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_exercise_id", nullable = false)
    private RoutineExercise routineExercise;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private SetType type;

    @Column(name = "order_index", nullable = false)
    private int orderIndex;

    @Builder
    public RoutineSet(RoutineExercise routineExercise, SetType type, int orderIndex) {
        this.id = UUID.randomUUID();
        this.routineExercise = routineExercise;
        this.type = type;
        this.orderIndex = orderIndex;
    }
}
