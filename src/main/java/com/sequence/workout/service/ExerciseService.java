package com.sequence.workout.service;

import com.sequence.workout.dto.ExerciseResponse;
import com.sequence.workout.mapper.ExerciseMapper;
import com.sequence.workout.model.Exercise;
import com.sequence.workout.repository.ExerciseRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExerciseService {
    private final ExerciseRepository exerciseRepository;

    @Transactional
    public List<ExerciseResponse> getCatalog(){
        return exerciseRepository.findAll(Sort.by("name"))
                .stream()
                .map(ExerciseMapper::toResponse)
                .toList();
    }
}
