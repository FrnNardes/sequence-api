-- Cable Exercises (Chest/Back/Arms/Shoulders)
INSERT INTO exercises (id, name, target_muscle, category) VALUES
(gen_random_uuid(), 'Tricep Pushdown (Cable)', 'ARMS', 'CABLE'),
(gen_random_uuid(), 'Tricep Rope Pushdown', 'ARMS', 'CABLE'),
(gen_random_uuid(), 'Overhead Cable Extension', 'ARMS', 'CABLE'),
(gen_random_uuid(), 'Bicep Curl (Cable)', 'ARMS', 'CABLE'),
(gen_random_uuid(), 'Hammer Curl (Cable)', 'ARMS', 'CABLE'),
(gen_random_uuid(), 'Face Pull (Cable)', 'SHOULDERS', 'CABLE'),
(gen_random_uuid(), 'Lateral Raise (Cable)', 'SHOULDERS', 'CABLE'),
(gen_random_uuid(), 'Front Raise (Cable)', 'SHOULDERS', 'CABLE'),
(gen_random_uuid(), 'Upright Row (Cable)', 'SHOULDERS', 'CABLE'),
(gen_random_uuid(), 'Cable Crossover (High to Low)', 'CHEST', 'CABLE'),
(gen_random_uuid(), 'Cable Crossover (Low to High)', 'CHEST', 'CABLE'),
(gen_random_uuid(), 'Single Arm Cable Press', 'CHEST', 'CABLE'),
(gen_random_uuid(), 'Lat Pulldown (Wide Grip)', 'BACK', 'CABLE'),
(gen_random_uuid(), 'Lat Pulldown (Close Grip)', 'BACK', 'CABLE'),
(gen_random_uuid(), 'Lat Pulldown (Reverse Grip)', 'BACK', 'CABLE'),
(gen_random_uuid(), 'Straight Arm Pulldown', 'BACK', 'CABLE'),
(gen_random_uuid(), 'Seated Row (Cable)', 'BACK', 'CABLE'),
(gen_random_uuid(), 'Single Arm Row (Cable)', 'BACK', 'CABLE'),
(gen_random_uuid(), 'Cable Crunch', 'CORE', 'CABLE'),
(gen_random_uuid(), 'Woodchopper (High to Low)', 'CORE', 'CABLE'),
(gen_random_uuid(), 'Woodchopper (Low to High)', 'CORE', 'CABLE'),
(gen_random_uuid(), 'Pallof Press', 'CORE', 'CABLE');

-- Kettlebell
INSERT INTO exercises (id, name, target_muscle, category) VALUES
(gen_random_uuid(), 'Kettlebell Swing', 'LEGS', 'KETTLEBELL'),
(gen_random_uuid(), 'Goblet Squat (Kettlebell)', 'LEGS', 'KETTLEBELL'),
(gen_random_uuid(), 'Turkish Get Up', 'FULL_BODY', 'KETTLEBELL'),
(gen_random_uuid(), 'Single Arm Press (Kettlebell)', 'SHOULDERS', 'KETTLEBELL'),
(gen_random_uuid(), 'Snatch (Kettlebell)', 'FULL_BODY', 'KETTLEBELL'),
(gen_random_uuid(), 'Clean and Press (Kettlebell)', 'FULL_BODY', 'KETTLEBELL'),
(gen_random_uuid(), 'Farmer Walk (Kettlebell)', 'FULL_BODY', 'KETTLEBELL');

-- Smith Machine
INSERT INTO exercises (id, name, target_muscle, category) VALUES
(gen_random_uuid(), 'Bench Press (Smith Machine)', 'CHEST', 'MACHINE'),
(gen_random_uuid(), 'Incline Bench Press (Smith Machine)', 'CHEST', 'MACHINE'),
(gen_random_uuid(), 'Shoulder Press (Smith Machine)', 'SHOULDERS', 'MACHINE'),
(gen_random_uuid(), 'Squat (Smith Machine)', 'LEGS', 'MACHINE'),
(gen_random_uuid(), 'Calf Raise (Smith Machine)', 'LEGS', 'MACHINE'),
(gen_random_uuid(), 'Shrug (Smith Machine)', 'BACK', 'MACHINE');

-- More Machines & Bodyweight
INSERT INTO exercises (id, name, target_muscle, category) VALUES
(gen_random_uuid(), 'Hack Squat', 'LEGS', 'MACHINE'),
(gen_random_uuid(), 'Hip Thrust (Machine)', 'LEGS', 'MACHINE'),
(gen_random_uuid(), 'Hip Abduction (Machine)', 'LEGS', 'MACHINE'),
(gen_random_uuid(), 'Hip Adduction (Machine)', 'LEGS', 'MACHINE'),
(gen_random_uuid(), 'Assisted Pull Up', 'BACK', 'MACHINE'),
(gen_random_uuid(), 'Assisted Dip', 'CHEST', 'MACHINE'),
(gen_random_uuid(), 'Back Extension (Hyperextension)', 'BACK', 'BODYWEIGHT'),
(gen_random_uuid(), 'Glute Bridge', 'LEGS', 'BODYWEIGHT'),
(gen_random_uuid(), 'Box Jump', 'LEGS', 'BODYWEIGHT'),
(gen_random_uuid(), 'Burpee', 'FULL_BODY', 'BODYWEIGHT'),
(gen_random_uuid(), 'Mountain Climber', 'CORE', 'BODYWEIGHT');

-- Cardio (Just in case)
INSERT INTO exercises (id, name, target_muscle, category) VALUES
(gen_random_uuid(), 'Treadmill Run', 'CARDIO', 'MACHINE'),
(gen_random_uuid(), 'Elliptical', 'CARDIO', 'MACHINE'),
(gen_random_uuid(), 'Rowing Machine', 'CARDIO', 'MACHINE'),
(gen_random_uuid(), 'Stair Climber', 'CARDIO', 'MACHINE');
