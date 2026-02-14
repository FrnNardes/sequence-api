package com.sequence.workout.repository;

import com.sequence.workout.model.RoutineExercise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoutineExerciseRepository extends JpaRepository<RoutineExercise, UUID> {
}
