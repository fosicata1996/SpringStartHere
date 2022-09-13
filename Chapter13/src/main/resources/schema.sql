CREATE TABLE IF NOT EXISTS account
(
    id      INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name varchar(50) NOT NULL,
    amount double NOT NULL
);