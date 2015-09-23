CREATE TABLE customers (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(30),
    last_name VARCHAR(30),
    username VARCHAR(100) NOT NULL DEFAULT 'test'
);

CREATE TABLE users (
    username VARCHAR(100) NOT NULL PRIMARY KEY,
    encodedPassword VARCHAR(255)
);