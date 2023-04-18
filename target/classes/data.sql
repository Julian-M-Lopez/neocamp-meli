DROP TABLE IF EXISTS SUPERHERO;

CREATE TABLE SUPERHERO (
  	id INT AUTO_INCREMENT PRIMARY KEY,
  	name VARCHAR(150) UNIQUE NOT NULL,
  	owner VARCHAR(150) NOT NULL,
  	created_at TIMESTAMP DEFAULT NULL,
  	updated_at TIMESTAMP DEFAULT NULL,
    active BOOLEAN 
);

INSERT INTO SUPERHERO (name, owner, created_at, updated_at, active) VALUES
  ('Spiderman', 'Marvel', '2022-01-22', '2022-01-22', true),
  ('Superman', 'DC', '2022-01-22', '2022-01-22', true),
  ('Batman', 'DC', '2022-01-22', '2022-01-22', true);
  