package com.sequence.workout.dto;

import com.sequence.workout.model.RoutineExercise;

import java.util.List;
import java.util.UUID;

public record RoutineResponse(
        UUID id,
        UUID userId,
        String name,
        List<RoutineExerciseResponse> exercises
)
{ }
