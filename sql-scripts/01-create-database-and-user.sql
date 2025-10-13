-- Datenbank anlegen, falls noch nicht vorhanden
CREATE DATABASE IF NOT EXISTS employee_db;

-- Benutzer anlegen (von überall zugänglich)
CREATE USER IF NOT EXISTS 'employee_user'@'%' IDENTIFIED BY 'employee_user';

-- Rechte nur auf diese Datenbank vergeben
GRANT ALL PRIVILEGES ON employee_db.* TO 'employee_user'@'%';

-- Rechte aktualisieren
FLUSH PRIVILEGES;
