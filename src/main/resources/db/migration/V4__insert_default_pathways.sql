-- 1. The Lifter Pathway
INSERT INTO pathways (id, name, description)
VALUES ('11111111-1111-1111-1111-111111111111',
        'The Lifter',
        'A path of iron and discipline. Focuses on raw strength and hypertrophy.');

-- Sequence 9: Gym Rat
INSERT INTO sequences (id, pathway_id, sequence_number, title, xp_required, ritual_description)
VALUES ('11111111-1111-1111-1111-000000000009', -- ID
        '11111111-1111-1111-1111-111111111111', -- Link to Lifter
        9,
        'Gym Rat',
        1000,
        'Complete 7 consecutive days of logging workouts.');

-- 2. The Runner Pathway
INSERT INTO pathways (id, name, description)
VALUES ('22222222-2222-2222-2222-222222222222',
        'The Runner',
        'A path of endurance and speed. Focuses on cardiovascular health and stamina.');

-- Sequence 9: Jogger
INSERT INTO sequences (id, pathway_id, sequence_number, title, xp_required, ritual_description)
VALUES ('22222222-2222-2222-2222-000000000009',
        '22222222-2222-2222-2222-222222222222', -- Link to Runner
        9,
        'Jogger',
        1000,
        'Run a total of 10km in a single week.');

-- 3. The Hybrid Pathway (Optional for now, but good to have)
INSERT INTO pathways (id, name, description)
VALUES ('33333333-3333-3333-3333-333333333333',
        'The Hybrid',
        'The balance of strength and endurance. The hardest path.');

-- Sequence 9: Weekend Warrior
INSERT INTO sequences (id, pathway_id, sequence_number, title, xp_required, ritual_description)
VALUES ('33333333-3333-3333-3333-000000000009',
        '33333333-3333-3333-3333-333333333333',
        9,
        'Weekend Warrior',
        1500, -- Harder!
        'Complete 2 strength workouts and 1 run in a week.');