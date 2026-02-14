package com.sequence.workout.dto;

import jakarta.validation.constraints.NotNull;

public record RoutineSetRequest(
        @NotNull
        String type
) {}
