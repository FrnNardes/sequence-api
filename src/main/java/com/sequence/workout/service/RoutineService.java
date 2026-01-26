package com.sequence.workout.service;

import com.sequence.user.model.User;
import com.sequence.user.repository.UserRepository;
import com.sequence.workout.dto.RoutineExerciseRequest;
import com.sequence.workout.dto.RoutineRequest;
import com.sequence.workout.dto.RoutineResponse;
import com.sequence.workout.dto.RoutineSetRequest;
import com.sequence.workout.mapper.RoutineMapper;
import com.sequence.workout.model.Exercise;
import com.sequence.workout.model.Routine;
import com.sequence.workout.model.RoutineExercise;
import com.sequence.workout.model.RoutineSet;
import com.sequence.workout.repository.ExerciseRepository;
import com.sequence.workout.repository.RoutineRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoutineService {
    private final RoutineRepository routineRepository;
    private final ExerciseRepository exerciseRepository;
    private final UserRepository userRepository;

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
}
