package com.sequence.workout.dto;

import com.sequence.workout.enums.SetType;

import java.util.UUID;

public record RoutineSetResponse(
        UUID id,
        SetType type,
        int orderIndex
) {}
