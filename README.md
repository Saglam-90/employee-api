# Spring Boot REST API - Employee Management

Dies ist eine **RESTful API** zur Verwaltung von Mitarbeitern, implementiert mit **Spring Boot**, **JPA/Hibernate** und **MySQL**.  
Das Projekt ermöglicht CRUD-Operationen (Create, Read, Update, Delete) auf einer `employee`-Tabelle.

---

## 📦 Features

- CRUD-Operationen für Employee:
  - GET `/api/employees` - Alle Mitarbeiter abrufen
  - GET `/api/employees/{id}` - Mitarbeiter nach ID abrufen
  - POST `/api/employees` - Neuen Mitarbeiter hinzufügen
  - PUT `/api/employees` - Bestehenden Mitarbeiter aktualisieren
  - DELETE `/api/employees/{id}` - Mitarbeiter löschen
- Automatische Erstellung der Tabelle `employee` durch JPA
- Testbar mit Postman oder einem beliebigen REST-Client

---

## 🛠 Voraussetzungen

- Java 17+
- Maven
- MySQL Server
- Optional: Postman oder ein anderer REST-Client

---

## ⚡ Installation

### 1. Datenbank anlegen

Führe die folgenden SQL-Befehle aus, um die Datenbank und den Benutzer zu erstellen:

```sql
CREATE DATABASE IF NOT EXISTS employee_db;
CREATE USER IF NOT EXISTS 'employee_user'@'%' IDENTIFIED BY 'employee_user';
GRANT ALL PRIVILEGES ON employee_db.* TO 'employee_user'@'%';
FLUSH PRIVILEGES;
```

Hinweis: Die Tabelle employee wird automatisch durch die Employee-Entity in Spring Boot erstellt.

### 2. Testdaten einfügen (optional: Nach dem Start der Anwendung können Testdaten eingefügt werden:)

```sql
USE employee_db;

INSERT INTO employee (first_name, last_name, email)
VALUES
    ('Sophia','Müller','sophia@gmail.com'),
    ('Lukas','Schneider','lukas@gmail.com'),
    ('Mia','Fischer','mia@gmail.com'),
    ('Noah','Weber','noah@gmail.com'),
    ('Lea','Becker','lea@gmail.com');
```

### 3. Projekt starten

1. Projekt klonen:
```
git clone https://github.com/Saglam-90/employee-api.git
cd employee-api
```

3. Maven Build:
```
mvn clean install
```
3. Spring Boot starten:
```
mvn spring-boot:run
```
Die API läuft nun standardmäßig auf:

http://localhost:8080/api

## 📝 API Endpoints

| Methode | Endpoint          | Beschreibung                          |
| ------- | ----------------- | ------------------------------------- |
| GET     | `/employees`      | Alle Mitarbeiter abrufen              |
| GET     | `/employees/{id}` | Mitarbeiter nach ID abrufen           |
| POST    | `/employees`      | Neuen Mitarbeiter erstellen           |
| PUT     | `/employees`      | Bestehenden Mitarbeiter aktualisieren |
| DELETE  | `/employees/{id}` | Mitarbeiter löschen                   |

Beispiel POST Request:

```json
{
"firstName": "Max",
"lastName": "Mustermann",
"email": "max@beispiel.com
}
```

## 📂 Projektstruktur

src/main/java/com/saglam/employeeapi
│
├── controller/ # REST Controller
├── entity/ # JPA Entities
├── repository/ # Spring Data JPA Repositories
└── service/ # Geschäftslogik

## 🔧 Konfiguration

In src/main/resources/application.properties:

spring.application.name=Spring Boot REST API - Employee Management
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=employee_user
spring.datasource.password=employee_user
spring.jpa.hibernate.ddl-auto=update

spring.jpa.hibernate.ddl-auto=update sorgt dafür, dass die Tabellen automatisch erstellt/aktualisiert werden.

## 🧪 Testen

Mit Postman oder cURL kann die API getestet werden.

Beispiele:

# Alle Employees abrufen

curl http://localhost:8080/api/employees

# Employee nach ID abrufen

curl http://localhost:8080/api/employees/1

# Neuen Employee hinzufügen

curl -X POST -H "Content-Type: application/json" -d '{"firstName":"Max","lastName":"Mustermann","email":"max@beispiel.com"}' http://localhost:8080/api/employees

# Employee löschen

curl -X DELETE http://localhost:8080/api/employees/1

```

```
