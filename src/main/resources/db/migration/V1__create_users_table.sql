CREATE TABLE users(
    id         UUID PRIMARY KEY,
    username   varchar NOT NULL,
    email      varchar NOT NULL UNIQUE,
    password   varchar NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);
