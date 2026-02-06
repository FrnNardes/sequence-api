package com.sequence.workout.service;

import com.sequence.user.model.User;
import com.sequence.user.repository.UserRepository;
import com.sequence.workout.dto.*;
import com.sequence.workout.enums.WorkoutStatus;
import com.sequence.workout.mapper.WorkoutMapper;
import com.sequence.workout.model.*;
import com.sequence.workout.repository.RoutineRepository;
import com.sequence.workout.repository.WorkoutRepository;
import com.sequence.workout.repository.WorkoutSetRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class WorkoutService {
    private final WorkoutRepository workoutRepository;
    private final UserRepository userRepository;
    private final RoutineRepository routineRepository;
    private final WorkoutSetRepository workoutSetRepository;

    @Transactional
    public WorkoutResponse createWorkout(String email, WorkoutRequest request){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Routine routine = routineRepository.findById(request.routineId())
                .orElseThrow(() -> new RuntimeException("Routine not found"));

        if (!routine.getUser().getId().equals(user.getId())) {
            throw new RuntimeException("Routine not found"); // Hide existence
        }

        Workout workout = WorkoutMapper.toEntity(routine, user);

        for(int i = 0; i < routine.getExercises().size(); i++){
            RoutineExercise routineExercise = routine.getExercises().get(i);

            WorkoutExercise workoutExercise = WorkoutMapper.toWorkoutExercise(workout, routineExercise, i + 1);

            for(int j = 0; j < routineExercise.getSets().size(); j++){
                RoutineSet routineSet = routineExercise.getSets().get(j);

                WorkoutSet workoutSet = WorkoutMapper.toWorkoutSet(workoutExercise, routineSet, j + 1);

                workoutExercise.getSets().add(workoutSet);
            }
            workout.getExercises().add(workoutExercise);
        }

        workoutRepository.save(workout);

        return WorkoutMapper.toResponse(workout);
    }

    @Transactional
    public void updateSet(UUID setId, UpdateSetRequest request, String email) throws AccessDeniedException {
        WorkoutSet set = workoutSetRepository.findById(setId)
                .orElseThrow(() -> new RuntimeException("Set not found"));

        Workout workout = set.getWorkoutExercise().getWorkout();

        if(!workout.getStatus().equals(WorkoutStatus.IN_PROGRESS)){
            throw new RuntimeException("This workout was closed");
        }

        if(!Objects.equals(workout.getUser().getEmail(), email)){
            throw new AccessDeniedException("This is not your workout, Hunter.");
        }

        // Update values first
        if (request.weight() != null) {
            set.setWeight(request.weight());
        }
        if (request.reps() != null) {
            set.setReps(request.reps());
        }

        // Validate if trying to complete
        if (Boolean.TRUE.equals(request.completed())) {
            boolean isWeightInvalid = set.getWeight() == null || set.getWeight() <= 0;
            boolean isRepsInvalid = set.getReps() == null || set.getReps() <= 0;

            if (isWeightInvalid || isRepsInvalid) {
                throw new RuntimeException("No shortcuts! Set weight and reps before completing the set.");
            }
        }

        // Update status
        if (request.completed() != null) {
            set.setCompleted(request.completed());
        }
    }

    @Transactional
    public WorkoutResponse finishWorkout(WorkoutFinishRequest request, UUID workoutId, String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not find"));

        Workout workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not found"));

        if(!Objects.equals(workout.getUser().getId(), user.getId())){
            throw new AccessDeniedException("This is not your workout");
        }

        if(WorkoutStatus.IN_PROGRESS != workout.getStatus()){
            throw new RuntimeException("This workout was already closed");
        }

        workout.endWorkout(request.notes());
        workoutRepository.save(workout);

        return WorkoutMapper.toResponse(workout);
    }

    @Transactional
    public void deleteWorkout(UUID workoutId, String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not find"));

        Workout workout = workoutRepository.findById(workoutId)
                .orElseThrow(() -> new RuntimeException("Workout not find"));

        if(!Objects.equals(workout.getUser().getId(), user.getId())){
            throw new AccessDeniedException("This is not your workout");
        }

        workoutRepository.delete(workout);
    }
}
