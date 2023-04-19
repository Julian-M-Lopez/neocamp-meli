DROP TABLE IF EXISTS SUPERHERO;

CREATE TABLE SUPERHERO (
   id LONG AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(150) UNIQUE NOT NULL,
   description VARCHAR(150) NOT NULL,
   capa BOOLEAN NOT NULL,
   city VARCHAR(150) NOT NULL

);

INSERT INTO SUPERHERO (name, description,capa,city) VALUES
  ('spiderman', ' araña', false, 'new york'),
  ('superman', ' es fuerte ', true, 'new york'),
  ('lintena verde', ' es verde ', true, 'los angeles'),
  ('mujer mariavilla', ' es mujer ', true, 'los angeles');


