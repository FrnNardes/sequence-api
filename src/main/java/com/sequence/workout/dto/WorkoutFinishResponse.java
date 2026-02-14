package com.sequence.workout.dto;

import java.time.OffsetDateTime;

public record WorkoutFinishResponse(
        OffsetDateTime endTime
) {
}
