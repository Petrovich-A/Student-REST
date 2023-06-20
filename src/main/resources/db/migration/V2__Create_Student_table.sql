-- student
--
CREATE TABLE IF NOT EXISTS st_rest.student
(
    id SERIAL,
    first_name VARCHAR(30) NOT NULL,
    last_name  VARCHAR(30) NOT NULL,
    PRIMARY KEY (id)
);