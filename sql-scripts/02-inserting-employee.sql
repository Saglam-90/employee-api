CREATE DATABASE  IF NOT EXISTS employee_db;

USE employee_db;

-- Hinweis: Die Tabelle 'employee' wird durch die Employee-Entity-Klasse in Spring Boot automatisch erstellt.
INSERT INTO employee (first_name, last_name, email)
VALUES 
	('Sophia','Müller','sophia@gmail.com'),
	('Lukas','Schneider','lukas@gmail.com'),
	('Mia','Fischer','mia@gmail.com'),
	('Noah','Weber','noah@gmail.com'),
	('Lea','Becker','lea@gmail.com');