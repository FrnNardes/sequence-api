package com.sequence.workout.mapper;

import com.sequence.workout.dto.ExerciseResponse;
import com.sequence.workout.model.Exercise;

public class ExerciseMapper {
    public static ExerciseResponse toResponse(Exercise exercise){
        return new ExerciseResponse(
            exercise.getId(),
            exercise.getName(),
            exercise.getTargetMuscle(),
            exercise.getCategory()
        );
    }
}
