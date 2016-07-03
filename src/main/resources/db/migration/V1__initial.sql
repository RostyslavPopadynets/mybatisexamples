CREATE TABLE persons (
  id        BIGINT AUTO_INCREMENT PRIMARY KEY,
  firstname VARCHAR,
  lastname  VARCHAR
);
CREATE TABLE documents (
  id   BIGINT AUTO_INCREMENT PRIMARY KEY,
  json VARCHAR
);
CREATE TABLE addresses (
  id        BIGINT AUTO_INCREMENT PRIMARY KEY,
  person_id BIGINT,
  street    VARCHAR,
  city      VARCHAR
);
CREATE TABLE products (
  id     BIGINT AUTO_INCREMENT PRIMARY KEY,
  name   VARCHAR     NOT NULL,
  type   VARCHAR(36) NOT NULL,
  actor  VARCHAR,
  artist VARCHAR
);
CREATE TABLE custom (
  id    BIGINT AUTO_INCREMENT PRIMARY KEY,
  value VARCHAR
);
