package com.sequence.workout.repository;

import com.sequence.workout.model.WorkoutSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface WorkoutSetRepository extends JpaRepository<WorkoutSet, UUID> {
}
