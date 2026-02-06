package com.sequence.workout.repository;

import com.sequence.workout.model.Routine;
import com.sequence.workout.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface WorkoutRepository extends JpaRepository<Workout, UUID> {
    List<Workout> findAllByRoutine(Routine routine);
}
