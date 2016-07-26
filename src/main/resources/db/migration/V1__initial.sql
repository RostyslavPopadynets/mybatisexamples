DROP TABLE IF EXISTS addresses;
DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS documents;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS custom;

CREATE TABLE persons (
  id        SERIAL PRIMARY KEY,
  firstname VARCHAR,
  lastname  VARCHAR
);
CREATE TABLE documents (
  id   SERIAL PRIMARY KEY,
  json VARCHAR
);
CREATE TABLE addresses (
  id        SERIAL PRIMARY KEY,
  person_id BIGINT,
  street    VARCHAR,
  city      VARCHAR
);
CREATE TABLE products (
  id     SERIAL PRIMARY KEY,
  name   VARCHAR     NOT NULL,
  type   VARCHAR(36) NOT NULL,
  actor  VARCHAR,
  artist VARCHAR
);
CREATE TABLE custom (
  id    SERIAL PRIMARY KEY,
  value VARCHAR
);

ALTER TABLE addresses ADD FOREIGN KEY (person_id) REFERENCES persons (id) ON DELETE CASCADE;