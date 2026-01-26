package com.sequence.workout.controller;

import com.sequence.workout.dto.RoutineRequest;
import com.sequence.workout.dto.RoutineResponse;
import com.sequence.workout.service.RoutineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/routines")
public class RoutineController {
    private final RoutineService routineService;

    @PostMapping
    public ResponseEntity<RoutineResponse> createRoutine(Authentication auth, @RequestBody @Valid RoutineRequest routineRequest){
        String email = (String) auth.getPrincipal(); // Changed to getPrincipal() because we set it as String in Filter
        System.out.println("Controller: Creating routine for " + email);

        RoutineResponse response = routineService.createRoutine(email, routineRequest);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
