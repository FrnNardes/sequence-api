package com.sequence.workout.mapper;

import com.sequence.user.model.User;
import com.sequence.workout.dto.*;
import com.sequence.workout.enums.SetType;
import com.sequence.workout.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RoutineMapper {

    // --- Response Mapping ---

    public static RoutineResponse toResponse(Routine routine){
        List<RoutineExerciseResponse> exercises = routine.getExercises().stream()
                .sorted(Comparator.comparingInt(RoutineExercise::getOrderIndex))
                .map(RoutineMapper::toExerciseResponse)
                .toList();

        return new RoutineResponse(
                routine.getId(),
                routine.getUser().getId(),
                routine.getName(),
                exercises
        );
    }

    private static RoutineExerciseResponse toExerciseResponse(RoutineExercise exercise) {
        List<RoutineSetResponse> sets = exercise.getSets().stream()
                .sorted(Comparator.comparingInt(RoutineSet::getOrderIndex))
                .map(RoutineMapper::toSetResponse)
                .toList();

        return new RoutineExerciseResponse(
                exercise.getId(),
                exercise.getExercise().getName(),
                exercise.getExercise().getTargetMuscle(),
                exercise.getOrderIndex(),
                sets
        );
    }

    private static RoutineSetResponse toSetResponse(RoutineSet set) {
        return new RoutineSetResponse(
                set.getId(),
                set.getType(),
                set.getOrderIndex()
        );
    }

    // --- Entity Mapping ---

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
