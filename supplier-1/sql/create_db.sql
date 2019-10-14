CREATE DATABASE IF NOT EXISTS supplier1;

USE supplier1;

CREATE TABLE IF NOT EXISTS films (
    film_id INT PRIMARY KEY AUTO_INCREMENT,
    film_name VARCHAR(50),
    film_desc VARCHAR(250)
);


INSERT INTO films (film_name, film_desc)
VALUES ('Catch me if you can', 'Interesting feeling film with Tom Hanks and Leonardo Di Caprio'),
       ('Pirates of the Carribean', 'Adventures of Captain Jack Sparrow'),
       ('Gattopardo', 'Film by Lucino Visconti about dying Italian familia');

SELECT * FROM films;
SELECT * FROM films WHERE film_name LIKE '%Gump%';
