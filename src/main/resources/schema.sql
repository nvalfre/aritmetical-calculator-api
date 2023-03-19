Drop table if exists records;
Drop table if exists operations;
Drop table if exists users;

CREATE TABLE users
(
    id       VARCHAR(120) PRIMARY KEY,
    username VARCHAR(255)   NOT NULL UNIQUE,
    password VARCHAR(255)   NOT NULL,
    active   BOOLEAN DEFAULT TRUE,
    balance  NUMERIC(18, 2) NOT NULL
);

CREATE TABLE operations
(
    id   BIGINT AUTO_INCREMENT PRIMARY KEY,
    type VARCHAR(50)    NOT NULL,
    cost NUMERIC(18, 2) NOT NULL
);

CREATE TABLE records
(
    id                 VARCHAR(120) PRIMARY KEY,
    operation_id       BIGINT         NOT NULL,
    user_id            BIGINT         NOT NULL,
    amount             NUMERIC(18, 2) NOT NULL,
    user_balance       NUMERIC(18, 2) NOT NULL,
    operation_response VARCHAR(250)  NOT NULL,
    date               TIMESTAMP      NOT NULL,
    deleted            BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (operation_id) REFERENCES operations (id),
    FOREIGN KEY (user_id) REFERENCES users (id)
);

INSERT INTO users (id, username, password, active, balance)
VALUES ('1', 'nv', '$2y$10$O.kjEmPsjh5BlxkeMwDSuehFFdBCCf59WO/AAB1u/P28kiIA/qG6C', true, 10000);

INSERT INTO operations (type, cost)
VALUES ('ADDITION', 1);
INSERT INTO operations (type, cost)
VALUES ('SUBTRACTION', 2);
INSERT INTO operations (type, cost)
VALUES ('MULTIPLICATION', 3);
INSERT INTO operations (type, cost)
VALUES ('DIVISION', 4);
INSERT INTO operations (type, cost)
VALUES ('SQUARE_ROOT', 5);
INSERT INTO operations (type, cost)
VALUES ('RANDOM_STRING', 6);
