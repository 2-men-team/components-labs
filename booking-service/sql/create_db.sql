CREATE DATABASE IF NOT EXISTS booking_service;

USE booking_service;

CREATE TABLE IF NOT EXISTS movie_shows (
    show_id INT PRIMARY KEY AUTO_INCREMENT,
    film_id INT,
    start_time DATETIME,
    end_time DATETIME,
    price INT,
    is_active BOOL
);

CREATE TABLE IF NOT EXISTS bookings (
    booking_id INT PRIMARY KEY AUTO_INCREMENT,
    show_id INT,
    FOREIGN KEY (show_id)
        REFERENCES movie_shows(show_id)
            ON DELETE CASCADE,
    first_name VARCHAR(25),
    last_name VARCHAR(25),
    email VARCHAR(25),
    phone_number VARCHAR(25)
);

CREATE TABLE IF NOT EXISTS booked_places (
    booking_id INT,
    place_number INT,
    show_id INT,
    PRIMARY KEY (booking_id, place_number)
);

-- INSERT INTO films (film_name, film_desc)
-- VALUES ('Forest gump', 'Brillian film with Tom hanks'),
--        ('Lord of the Rings', 'Fantastic novel film based on novel By Tolkien'),
--        ('Interstellar', 'Film with Mathiue Macconaghi');

INSERT INTO movie_shows (film_id, start_time, end_time, price, is_active)
VALUES (1, '2019-09-18 16:00:00', '2019-09-18 18:00:00', 120, TRUE),
       (1, '2019-09-18 10:00:00', '2019-09-18 12:00:00', 100, TRUE),
       (1, '2019-09-18 14:00:00', '2019-09-18 16:00:00', 110, TRUE);

-- INSERT INTO bookings (show_id, first_name, last_name, email, phone_number)
-- VALUES (1, 'Vladyslav', 'Mokrousov', 'elminsteraumar4@gmail.com', '+380939826288');


-- SELECT * FROM movie_shows WHERE film_id=1 AND start_time='2019-09-18 16:00:00';
-- SELECT * FROM bookings;
-- SELECT * FROM booked_places;
-- SELECT * FROM films;
-- SELECT * FROM films WHERE film_name LIKE '%Gump%';