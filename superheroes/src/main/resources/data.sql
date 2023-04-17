DROP TABLE IF EXISTS SUPERHERO;

CREATE TABLE SUPERHERO (
                           id INT AUTO_INCREMENT PRIMARY KEY,
                           name VARCHAR(150) UNIQUE NOT NULL,
                           description VARCHAR(150) NOT NULL,
                           capa BOOLEAN
);

INSERT INTO SUPERHERO (name, description, capa) VALUES('Spiderman', 'Superman', false),
                                                       ('Superman', 'Friendly Neighborhood Spider-Man', true),
                                                       ('Batman', 'Dark Man', true);

