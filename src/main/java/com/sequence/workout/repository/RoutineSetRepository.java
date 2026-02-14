package com.sequence.workout.repository;

import com.sequence.workout.model.RoutineSet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoutineSetRepository extends JpaRepository<RoutineSet, UUID> {
}
