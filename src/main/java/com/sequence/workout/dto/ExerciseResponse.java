package com.sequence.workout.dto;

import com.sequence.workout.enums.ExerciseCategory;

import java.util.UUID;

public record ExerciseResponse(
        UUID id,
        String name,
        String targetMuscle,
        ExerciseCategory category
) {
}
