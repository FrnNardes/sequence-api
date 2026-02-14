package com.sequence.workout.dto;

import jakarta.validation.constraints.NotNull;
import java.util.UUID;

public record WorkoutRequest(
        @NotNull
        UUID routineId
) {}
