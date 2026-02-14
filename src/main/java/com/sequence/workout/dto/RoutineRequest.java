package com.sequence.workout.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RoutineRequest(
        @NotBlank(message = "Name is required")
        String name,

        @NotNull
        @Valid
        List<RoutineExerciseRequest> exercises
) {}
