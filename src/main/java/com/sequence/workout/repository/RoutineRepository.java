package com.sequence.workout.repository;

import com.sequence.user.model.User;
import com.sequence.workout.model.Routine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RoutineRepository extends JpaRepository<Routine, UUID> {
    Optional<Routine> findByUserIdAndName(UUID userId, String name);

    Optional<Routine> findByIdAndUser(UUID id, User user);

    List<Routine> findAllByUser(User user);
}
