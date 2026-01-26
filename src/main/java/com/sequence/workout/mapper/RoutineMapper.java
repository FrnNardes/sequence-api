package com.sequence.workout.mapper;

import com.sequence.user.model.User;
import com.sequence.workout.dto.RoutineExerciseRequest;
import com.sequence.workout.dto.RoutineRequest;
import com.sequence.workout.dto.RoutineResponse;
import com.sequence.workout.dto.RoutineSetRequest;
import com.sequence.workout.enums.SetType;
import com.sequence.workout.model.Exercise;
import com.sequence.workout.model.Routine;
import com.sequence.workout.model.RoutineExercise;
import com.sequence.workout.model.RoutineSet;

import java.util.ArrayList;

public class RoutineMapper {
    public static RoutineResponse toResponse(Routine routine){
        return new RoutineResponse(
                routine.getId(),
                routine.getUser().getId(),
                routine.getName());
    }
    public static Routine toEntity(RoutineRequest request, User user) {
        return Routine.builder()
                .user(user)
                .name(request.name())
                .exercises(new ArrayList<>())
                .build();
    }

    public static RoutineExercise toRoutineExercise(RoutineExerciseRequest request, Routine parent, Exercise exercise, int orderIndex) {
        return RoutineExercise.builder()
                .routine(parent)
                .exercise(exercise)
                .orderIndex(orderIndex)
                .sets(new ArrayList<>())
                .build();
    }

    public static RoutineSet toRoutineSet(RoutineSetRequest request, RoutineExercise parent, int orderIndex) {
        return RoutineSet.builder()
                .routineExercise(parent)
                .type(SetType.valueOf(request.type()))
                .orderIndex(orderIndex)
                .build();
    }
}
