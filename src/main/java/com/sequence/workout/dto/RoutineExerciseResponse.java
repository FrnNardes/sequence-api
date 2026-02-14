package com.sequence.workout.dto;

import java.util.List;
import java.util.UUID;

public record RoutineExerciseResponse(
        UUID id,
        String exerciseName,
        String targetMuscle,
        int orderIndex,
        List<RoutineSetResponse> sets
) {}
