CREATE TABLE pathways(
    id UUID PRIMARY KEY,
    name VARCHAR NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE sequences(
    id UUID PRIMARY KEY,
    pathway_id UUID NOT NULL REFERENCES pathways(id),
    title VARCHAR NOT NULL,
    sequence_number INT NOT NULL,
    xp_required INT NOT NULL,
    ritual_description TEXT
);

