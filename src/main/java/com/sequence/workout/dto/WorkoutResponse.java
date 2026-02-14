package com.sequence.workout.dto;

import com.sequence.workout.enums.WorkoutStatus;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

public record WorkoutResponse(
        UUID id,
        String routineName,
        OffsetDateTime startTime,
        OffsetDateTime endTime,
        WorkoutStatus status,
        List<WorkoutExerciseResponse> exercises
) {}
