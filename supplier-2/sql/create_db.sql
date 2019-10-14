CREATE DATABASE IF NOT EXISTS supplier2;

USE supplier2;

CREATE TABLE IF NOT EXISTS films (
    film_id INT PRIMARY KEY AUTO_INCREMENT,
    film_name VARCHAR(50),
    film_desc VARCHAR(250)
);


INSERT INTO films (film_name, film_desc)
VALUES ('The hobbit', 'Adventures of Bilbo Baggins by Ruel Tolkien'),
       ('Kalina Krasnaya', 'Film by Vasiliy Shukshin'),
       ('Avatar', 'Film about Pandora planet and avatars - aliens that habituated it');

SELECT * FROM films;
SELECT * FROM films WHERE film_name LIKE '%Gump%';
