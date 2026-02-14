package com.sequence.workout.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record RoutineExerciseRequest(
        @NotNull
        UUID exerciseId,

        @NotNull
        int order,

        @NotNull
        @Valid
        List<RoutineSetRequest> sets
) {}