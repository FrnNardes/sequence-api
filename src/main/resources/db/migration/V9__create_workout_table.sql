CREATE TABLE workouts(
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id),
    routine_id UUID REFERENCES routines(id),
    start_time TIMESTAMP WITH TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    end_time TIMESTAMP WITH TIME ZONE,
    status VARCHAR NOT NULL,
    notes TEXT
);

CREATE TABLE workout_exercises(
    id UUID PRIMARY KEY,
    workout_id UUID NOT NULL REFERENCES workouts(id),
    exercise_id UUID NOT NULL REFERENCES exercises(id),
    order_index INT NOT NULL,
    UNIQUE(workout_id, order_index)
);

CREATE TABLE workout_sets(
    id UUID PRIMARY KEY,
    workout_exercise_id UUID NOT NULL REFERENCES workout_exercises(id),
    weight DOUBLE PRECISION,
    reps INT,
    order_index INT NOT NULL,
    type VARCHAR NOT NULL,
    completed BOOLEAN NOT NULL DEFAULT FALSE,
    UNIQUE(workout_exercise_id, order_index)
);