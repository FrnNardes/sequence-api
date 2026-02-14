package com.sequence.workout.service;

import com.sequence.user.model.User;
import com.sequence.user.repository.UserRepository;
import com.sequence.workout.dto.*;
import com.sequence.workout.mapper.RoutineMapper;
import com.sequence.workout.model.*;
import com.sequence.workout.repository.ExerciseRepository;
import com.sequence.workout.repository.RoutineRepository;
import com.sequence.workout.repository.WorkoutRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoutineService {
    private final RoutineRepository routineRepository;
    private final ExerciseRepository exerciseRepository;
    private final UserRepository userRepository;
    private final WorkoutService workoutService;
    private final WorkoutRepository workoutRepository;

    @Transactional
    public RoutineResponse createRoutine(String email, RoutineRequest request){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Routine routine = RoutineMapper.toEntity(request, user);

        for(int i = 0; i < request.exercises().size(); i++){
            RoutineExerciseRequest exerciseRequest = request.exercises().get(i);
            
            Exercise exercise = exerciseRepository.findById(exerciseRequest.exerciseId())
                    .orElseThrow(() -> new RuntimeException("Exercise not found"));

            RoutineExercise routineExercise = RoutineMapper.toRoutineExercise(exerciseRequest, routine, exercise, i + 1);

            for(int j = 0; j < exerciseRequest.sets().size(); j++){
                RoutineSetRequest setRequest = exerciseRequest.sets().get(j);
                
                RoutineSet set = RoutineMapper.toRoutineSet(setRequest, routineExercise, j + 1);

                routineExercise.getSets().add(set);
            }

            routine.getExercises().add(routineExercise);
        }

        routineRepository.save(routine);

        return RoutineMapper.toResponse(routine);
    }

    @Transactional
    public void deleteRoutine(String email, UUID id){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Routine routine = routineRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new RuntimeException("Routine not found"));

        List<Workout> workouts = workoutRepository.findAllByRoutine(routine);
        for(Workout w : workouts){
            w.removeRoutine();
        }

        workoutRepository.saveAll(workouts);

        routineRepository.delete(routine);
    }

    @Transactional
    public List<RoutineResponse> getAllRoutines(String email){
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        return routineRepository.findAllByUser(user)
                .stream()
                .map(RoutineMapper::toResponse)
                .toList();
    }
}
