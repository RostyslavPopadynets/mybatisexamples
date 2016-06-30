CREATE TABLE persons (
  id        BIGINT AUTO_INCREMENT,
  firstname VARCHAR,
  lastname  VARCHAR
);
CREATE TABLE documents (
  id   BIGINT AUTO_INCREMENT,
  json VARCHAR
);
CREATE TABLE addresses (
  id        BIGINT AUTO_INCREMENT,
  person_id BIGINT,
  street    VARCHAR,
  city      VARCHAR
);
