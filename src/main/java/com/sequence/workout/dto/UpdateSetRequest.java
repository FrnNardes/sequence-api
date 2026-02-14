package com.sequence.workout.dto;

public record UpdateSetRequest(
        Double weight,
        Integer reps,
        Boolean completed
) {
}
