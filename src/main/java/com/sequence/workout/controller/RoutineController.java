package com.sequence.workout.controller;

import com.sequence.workout.dto.RoutineRequest;
import com.sequence.workout.dto.RoutineResponse;
import com.sequence.workout.service.RoutineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/routines")
public class RoutineController {
    private final RoutineService routineService;

    @PostMapping
    public ResponseEntity<RoutineResponse> createRoutine(Authentication auth, @RequestBody @Valid RoutineRequest routineRequest){
        String email = (String) auth.getPrincipal();
        RoutineResponse response = routineService.createRoutine(email, routineRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<RoutineResponse>> getRoutines(Authentication auth){
        String email = (String) auth.getPrincipal();
        List<RoutineResponse> response = routineService.getAllRoutines(email);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoutineResponse> deleteRoutine(Authentication auth, @PathVariable UUID id) {
        String email = (String) auth.getPrincipal();
        routineService.deleteRoutine(email, id);
        return ResponseEntity.noContent().build();
    }
}
