CREATE TABLE users
(
    id       BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    active   BOOLEAN DEFAULT TRUE
);

CREATE TABLE operations
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50)    NOT NULL,
    cost NUMERIC(18, 2) NOT NULL
);

CREATE TABLE records
(
    id                 BIGINT AUTO_INCREMENT PRIMARY KEY,
    operation_id       BIGINT         NOT NULL,
    user_id            BIGINT         NOT NULL,
    amount             NUMERIC(18, 2) NOT NULL,
    user_balance       NUMERIC(18, 2) NOT NULL,
    operation_response NUMERIC(18, 2) NOT NULL ,
    date               TIMESTAMP      NOT NULL,
    deleted            BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (operation_id) REFERENCES operations (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);