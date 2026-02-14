package com.sequence.workout.dto;

import com.sequence.workout.enums.SetType;

import java.util.UUID;

public record WorkoutSetResponse(
        UUID id,
        Double weight,
        Integer reps,
        int orderIndex,
        SetType type,
        boolean completed,
        Double pastWeight,
        Integer pastReps
) {}
