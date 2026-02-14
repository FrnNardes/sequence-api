-- Chest
INSERT INTO exercises (id, name, target_muscle, category) VALUES
(gen_random_uuid(), 'Bench Press (Barbell)', 'CHEST', 'BARBELL'),
(gen_random_uuid(), 'Incline Bench Press (Barbell)', 'CHEST', 'BARBELL'),
(gen_random_uuid(), 'Decline Bench Press (Barbell)', 'CHEST', 'BARBELL'),
(gen_random_uuid(), 'Bench Press (Dumbbell)', 'CHEST', 'DUMBBELL'),
(gen_random_uuid(), 'Incline Bench Press (Dumbbell)', 'CHEST', 'DUMBBELL'),
(gen_random_uuid(), 'Chest Fly (Dumbbell)', 'CHEST', 'DUMBBELL'),
(gen_random_uuid(), 'Push Up', 'CHEST', 'BODYWEIGHT'),
(gen_random_uuid(), 'Chest Dip', 'CHEST', 'BODYWEIGHT'),
(gen_random_uuid(), 'Chest Press (Machine)', 'CHEST', 'MACHINE'),
(gen_random_uuid(), 'Pec Deck Fly', 'CHEST', 'MACHINE'),
(gen_random_uuid(), 'Cable Crossover', 'CHEST', 'MACHINE');

-- Back
INSERT INTO exercises (id, name, target_muscle, category) VALUES
(gen_random_uuid(), 'Deadlift (Barbell)', 'BACK', 'BARBELL'),
(gen_random_uuid(), 'Bent Over Row (Barbell)', 'BACK', 'BARBELL'),
(gen_random_uuid(), 'Pull Up', 'BACK', 'BODYWEIGHT'),
(gen_random_uuid(), 'Chin Up', 'BACK', 'BODYWEIGHT'),
(gen_random_uuid(), 'Lat Pulldown', 'BACK', 'MACHINE'),
(gen_random_uuid(), 'Seated Cable Row', 'BACK', 'MACHINE'),
(gen_random_uuid(), 'Single Arm Row (Dumbbell)', 'BACK', 'DUMBBELL'),
(gen_random_uuid(), 'T-Bar Row', 'BACK', 'MACHINE'),
(gen_random_uuid(), 'Face Pull', 'BACK', 'MACHINE');

-- Legs (Quads/Hamstrings/Glutes)
INSERT INTO exercises (id, name, target_muscle, category) VALUES
(gen_random_uuid(), 'Squat (Barbell)', 'LEGS', 'BARBELL'),
(gen_random_uuid(), 'Front Squat (Barbell)', 'LEGS', 'BARBELL'),
(gen_random_uuid(), 'Romanian Deadlift (Barbell)', 'LEGS', 'BARBELL'),
(gen_random_uuid(), 'Goblet Squat', 'LEGS', 'DUMBBELL'),
(gen_random_uuid(), 'Lunges (Dumbbell)', 'LEGS', 'DUMBBELL'),
(gen_random_uuid(), 'Bulgarian Split Squat', 'LEGS', 'DUMBBELL'),
(gen_random_uuid(), 'Leg Press', 'LEGS', 'MACHINE'),
(gen_random_uuid(), 'Leg Extension', 'LEGS', 'MACHINE'),
(gen_random_uuid(), 'Leg Curl (Seated)', 'LEGS', 'MACHINE'),
(gen_random_uuid(), 'Leg Curl (Lying)', 'LEGS', 'MACHINE'),
(gen_random_uuid(), 'Calf Raise (Standing)', 'LEGS', 'MACHINE'),
(gen_random_uuid(), 'Calf Raise (Seated)', 'LEGS', 'MACHINE');

-- Shoulders
INSERT INTO exercises (id, name, target_muscle, category) VALUES
(gen_random_uuid(), 'Overhead Press (Barbell)', 'SHOULDERS', 'BARBELL'),
(gen_random_uuid(), 'Shoulder Press (Dumbbell)', 'SHOULDERS', 'DUMBBELL'),
(gen_random_uuid(), 'Lateral Raise (Dumbbell)', 'SHOULDERS', 'DUMBBELL'),
(gen_random_uuid(), 'Front Raise (Dumbbell)', 'SHOULDERS', 'DUMBBELL'),
(gen_random_uuid(), 'Arnold Press', 'SHOULDERS', 'DUMBBELL'),
(gen_random_uuid(), 'Reverse Fly (Dumbbell)', 'SHOULDERS', 'DUMBBELL'),
(gen_random_uuid(), 'Shoulder Press (Machine)', 'SHOULDERS', 'MACHINE');

-- Arms (Biceps/Triceps)
INSERT INTO exercises (id, name, target_muscle, category) VALUES
(gen_random_uuid(), 'Barbell Curl', 'ARMS', 'BARBELL'),
(gen_random_uuid(), 'Dumbbell Curl', 'ARMS', 'DUMBBELL'),
(gen_random_uuid(), 'Hammer Curl', 'ARMS', 'DUMBBELL'),
(gen_random_uuid(), 'Preacher Curl (Machine)', 'ARMS', 'MACHINE'),
(gen_random_uuid(), 'Tricep Extension (Cable)', 'ARMS', 'MACHINE'),
(gen_random_uuid(), 'Skullcrusher (Barbell)', 'ARMS', 'BARBELL'),
(gen_random_uuid(), 'Tricep Dip', 'ARMS', 'BODYWEIGHT'),
(gen_random_uuid(), 'Tricep Kickback (Dumbbell)', 'ARMS', 'DUMBBELL');

-- Core
INSERT INTO exercises (id, name, target_muscle, category) VALUES
(gen_random_uuid(), 'Plank', 'CORE', 'BODYWEIGHT'),
(gen_random_uuid(), 'Crunch', 'CORE', 'BODYWEIGHT'),
(gen_random_uuid(), 'Leg Raise (Hanging)', 'CORE', 'BODYWEIGHT'),
(gen_random_uuid(), 'Russian Twist', 'CORE', 'BODYWEIGHT'),
(gen_random_uuid(), 'Ab Wheel Rollout', 'CORE', 'BODYWEIGHT');
