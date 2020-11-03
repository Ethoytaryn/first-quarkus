CREATE SCHEMA poc;
CREATE TABLE poc.evenement (
    id SERIAL CONSTRAINT primary_key_cat PRIMARY KEY,
    name TEXT,
    debut date,
    duree int
);
