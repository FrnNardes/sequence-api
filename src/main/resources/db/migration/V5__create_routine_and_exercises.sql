CREATE TABLE exercises(
    id UUID PRIMARY KEY,
    name VARCHAR NOT NULL UNIQUE,
    target_muscle VARCHAR NOT NULL,
    category varchar
);

CREATE TABLE routines(
    id UUID PRIMARY KEY,
    user_id UUID NOT NULL REFERENCES users(id),
    name VARCHAR NOT NULL
);

CREATE TABLE routine_exercises(
    id UUID PRIMARY KEY,
    routine_id UUID NOT NULL REFERENCES routines(id),
    exercise_id UUID NOT NULL REFERENCES exercises(id),
    "order" INT NOT NULL
);

CREATE TABLE routine_sets(
    id UUID PRIMARY KEY,
    routine_exercise_id UUID NOT NULL REFERENCES routine_exercises(id),
    type VARCHAR NOT NULL
);
