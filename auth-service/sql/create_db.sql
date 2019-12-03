CREATE DATABASE IF NOT EXISTS auth;

USE auth;

CREATE TABLE IF NOT EXISTS auth_data (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    email VARCHAR(50),
    api_key VARCHAR(100)
);
