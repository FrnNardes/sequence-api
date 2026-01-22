ALTER TABLE users
ADD COLUMN pathway_id UUID REFERENCES pathways(id),
ADD COLUMN current_sequence_id UUID REFERENCES sequences(id),
ADD COLUMN current_xp INT DEFAULT 0;