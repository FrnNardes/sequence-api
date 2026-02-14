package com.sequence.workout.mapper;

import com.sequence.user.model.User;
import com.sequence.workout.dto.WorkoutExerciseResponse;
import com.sequence.workout.dto.WorkoutResponse;
import com.sequence.workout.dto.WorkoutSetResponse;
import com.sequence.workout.model.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorkoutMapper {

    // --- Response Mapping ---

    public static WorkoutResponse toResponse(Workout workout) {
        List<WorkoutExerciseResponse> exercises = workout.getExercises().stream()
                .sorted(Comparator.comparingInt(WorkoutExercise::getOrderIndex))
                .map(WorkoutMapper::toExerciseResponse)
                .toList();

        return new WorkoutResponse(
                workout.getId(),
                workout.getRoutine() != null ? workout.getRoutine().getName() : "Freestyle",
                workout.getStartTime(),
                workout.getEndTime(),
                workout.getStatus(),
                exercises
        );
    }

    private static WorkoutExerciseResponse toExerciseResponse(WorkoutExercise exercise) {
        List<WorkoutSetResponse> sets = exercise.getSets().stream()
                .sorted(Comparator.comparingInt(WorkoutSet::getOrderIndex))
                .map(WorkoutMapper::toSetResponse)
                .toList();

        return new WorkoutExerciseResponse(
                exercise.getId(),
                exercise.getExercise().getName(),
                exercise.getExercise().getTargetMuscle(),
                exercise.getOrderIndex(),
                sets
        );
    }

    private static WorkoutSetResponse toSetResponse(WorkoutSet set) {
        return new WorkoutSetResponse(
                set.getId(),
                set.getWeight(),
                set.getReps(),
                set.getOrderIndex(),
                set.getType(),
                set.getCompleted(),
                null, // Past Weight (Future Feature)
                null  // Past Reps (Future Feature)
        );
    }

    // --- Entity Mapping ---

    public static Workout toEntity(Routine routine, User user){
        return Workout.builder()
                .user(user)
                .routine(routine)
                .exercises(new ArrayList<>())
                .build();
    }

    public static WorkoutExercise toWorkoutExercise(Workout workout, RoutineExercise routineExercise, int orderIndex){
        return WorkoutExercise.builder()
                .workout(workout)
                .exercise(routineExercise.getExercise())
                .sets(new ArrayList<>())
                .orderIndex(orderIndex)
                .build();
    }

    public static WorkoutSet toWorkoutSet(WorkoutExercise workoutExercise, RoutineSet routineSet, int orderIndex){
        return WorkoutSet.builder()
                .workoutExercise(workoutExercise)
                .type(routineSet.getType())
                .completed(false)
                .orderIndex(orderIndex)
                .build();
    }
}
