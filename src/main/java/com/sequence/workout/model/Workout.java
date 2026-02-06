package com.sequence.workout.model;

import com.sequence.user.model.User;
import com.sequence.workout.enums.WorkoutStatus;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "workouts")
@Getter
public class Workout {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "routine_id", nullable = true)
    private Routine routine;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WorkoutExercise> exercises;

    @Column(name = "start_time", updatable = false)
    private OffsetDateTime startTime;

    @Column(name = "end_time")
    private OffsetDateTime endTime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private WorkoutStatus status;

    private String notes;

    @Builder
    public Workout(User user, Routine routine, List<WorkoutExercise> exercises){
        this.id = UUID.randomUUID();
        this.user = user;
        this.routine = routine;
        this.exercises = exercises;
        this.startTime = OffsetDateTime.now();
        this.status = WorkoutStatus.IN_PROGRESS;
        this.notes = "";
    }

    public void endWorkout(String notes){
        this.endTime = OffsetDateTime.now();
        this.status = WorkoutStatus.COMPLETED;
        updateNotes(notes);
    }

    public void updateNotes(String notes){
        this.notes = notes;
    }

    public void removeRoutine() { this.routine = null; }
}
