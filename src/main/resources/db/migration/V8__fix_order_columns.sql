-- Fix Routine Exercises
ALTER TABLE routine_exercises
RENAME COLUMN "order" TO order_index;

-- Add Unique Constraint to Routine Exercises (One exercise per position per routine)
ALTER TABLE routine_exercises
ADD CONSTRAINT unique_routine_order UNIQUE (routine_id, order_index);

-- Fix Routine Sets
ALTER TABLE routine_sets
ADD COLUMN order_index INT NOT NULL DEFAULT 0;

-- Add Unique Constraint to Routine Sets (One set per position per exercise)
ALTER TABLE routine_sets
ADD CONSTRAINT unique_set_order UNIQUE (routine_exercise_id, order_index);