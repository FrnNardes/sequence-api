package com.sequence.workout.controller;

import com.sequence.workout.dto.ExerciseResponse;
import com.sequence.workout.service.ExerciseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/exercises")
public class ExerciseController {
    private final ExerciseService exerciseService;

    @GetMapping
    public ResponseEntity<List<ExerciseResponse>> getCatalog(){
        List<ExerciseResponse> response = exerciseService.getCatalog();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
