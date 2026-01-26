package com.sequence.workout.dto;

import com.sequence.workout.model.RoutineExercise;

import java.util.List;
import java.util.UUID;

public record RoutineResponse(
        UUID id,
        UUID userId,
        String name
        // List<RoutineExercise> exercises - If we want to return this, we must build a response
        // because inside RoutineExercise, we have a Routine, which has a Routine Exercise, and this
        // creates an infinite loop.
)
{ }
