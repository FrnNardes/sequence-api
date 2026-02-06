package com.sequence.workout.controller;

import com.sequence.workout.dto.*;
import com.sequence.workout.service.WorkoutService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/workouts")
public class WorkoutController {
    private final WorkoutService workoutService;

    @PostMapping("/start")
    public ResponseEntity<WorkoutResponse> createWorkout(Authentication auth, @RequestBody WorkoutRequest workoutRequest){
        String email = (String) auth.getPrincipal();
        WorkoutResponse response = workoutService.createWorkout(email, workoutRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(Authentication auth, @PathVariable UUID id){
        String email = (String) auth.getPrincipal();
        workoutService.deleteWorkout(id, email);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/finish")
    public ResponseEntity<WorkoutResponse> finishWorkout(Authentication auth, @PathVariable UUID id, @RequestBody WorkoutFinishRequest request){
        String email = (String) auth.getPrincipal();
        WorkoutResponse response = workoutService.finishWorkout(request, id, email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PatchMapping("/sets/{id}")
    public ResponseEntity<Void> updateSet(Authentication auth, @PathVariable UUID id, @RequestBody UpdateSetRequest request){
        String email = (String) auth.getPrincipal();
        workoutService.updateSet(id, request, email);
        return ResponseEntity.noContent().build();
    }
}
