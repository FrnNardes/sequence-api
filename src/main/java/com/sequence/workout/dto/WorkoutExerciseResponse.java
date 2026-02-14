package com.sequence.workout.dto;

import java.util.List;
import java.util.UUID;

public record WorkoutExerciseResponse(
        UUID id,
        String exerciseName,
        String targetMuscle,
        int orderIndex,
        List<WorkoutSetResponse> sets
) {}
