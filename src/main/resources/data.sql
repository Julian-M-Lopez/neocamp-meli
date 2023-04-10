DROP TABLE IF EXISTS SUPERHERO;

CREATE TABLE SUPERHERO (
   id INT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(150) UNIQUE NOT NULL,
   description VARCHAR(150) NOT NULL,
   capa BOOLEAN NOT NULL,
   city VARCHAR(150) NOT NULL

);

INSERT INTO SUPERHERO (name, description,capa,city) VALUES
  ('Spiderman', ' araña', false, 'new york'),
  ('Superman', ' es fuerte ', true, 'new york'),
  ('lintena verde', ' es verde ', true, 'los angeles');