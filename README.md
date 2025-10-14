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

> 💡 Die Tabelle `employee` wird automatisch durch die Employee-Entity in Spring Boot erstellt.

---

### 2. Testdaten einfügen (optional: Nach dem Start der Anwendung können Testdaten eingefügt werden)

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

---

### 3. Projekt starten

1. Projekt klonen:
```
git clone https://github.com/Saglam-90/employee-api.git
cd employee-api
```

2. Maven Build im Projektordner:
```
./mvnw clean install
```
3. Spring Boot starten:
```
./mvnw spring-boot:run
```
Die API läuft nun standardmäßig auf:
👉 [http://localhost:8080/api/employees](http://localhost:8080/api/employees)

---

## 📝 API Endpoints

| Methode | Endpoint          | Beschreibung                          |
| ------- | ----------------- | ------------------------------------- |
| GET     | `/employees`      | Alle Mitarbeiter abrufen              |
| GET     | `/employees/{id}` | Mitarbeiter nach ID abrufen           |
| POST    | `/employees`      | Neuen Mitarbeiter erstellen           |
| PUT     | `/employees`      | Bestehenden Mitarbeiter aktualisieren |
| DELETE  | `/employees/{id}` | Mitarbeiter löschen                   |

**Beispiel POST Request:**

```json
{
"firstName": "Max",
"lastName": "Mustermann",
"email": "max@beispiel.com"
}
```

---

## 📂 Projektstruktur
```plaintext
employee-api/
│
├── src/
│   ├── main/
│   │   ├── java/com/saglam/employeeapi/
│   │   │   ├── controller/
│   │   │   │   └── EmployeeController.java
│   │   │   ├── entity/
│   │   │   │   └── Employee.java
│   │   │   ├── repository/
│   │   │   │   └── EmployeeRepository.java
│   │   │   └── service/
│   │   │       └── EmployeeService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── static/
│   └── test/
│       └── java/com/saglam/employeeapi/
│           └── EmployeeApiApplicationTests.java
│
├── .gitignore
├── pom.xml
├── README.md
└── mvnw / mvnw.cmd
```

---

## 🔧 Konfiguration

**Datei:** `src/main/resources/application.properties`

```properties
spring.application.name=Spring Boot REST API - Employee Management
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=employee_user
spring.datasource.password=employee_user
spring.jpa.hibernate.ddl-auto=update
```

> 🧩 `spring.jpa.hibernate.ddl-auto=update` sorgt dafür, dass die Tabellen automatisch erstellt bzw. aktualisiert werden.

---

## 🧪 Testen

Mit **Postman** oder **cURL** kann die API getestet werden.
Die folgenden `curl`-Beispiele sind für **Git Bash**, **Linux** oder **macOS** formatiert.
👉 [Postman herunterladen](https://www.postman.com/)

> 💡 **Hinweis für Windows-Nutzer:**  
> Wenn du **CMD** oder **PowerShell** verwendest, ersetze einfache Anführungszeichen `'` durch doppelte `"`  
> und entferne die Backslashes `\` (oder nutze in PowerShell stattdessen den Backtick `` ` `` für Zeilenumbrüche).

Nach dem Start der Anwendung stehen folgende Endpunkte zur Verfügung:

---

### 🔹 Alle Employees abrufen

**GET**  
```bash
curl -X GET http://localhost:8080/api/employees
```
Oder im Browser direkt aufrufen:
[http://localhost:8080/api/employees](http://localhost:8080/api/employees)

---

### 🔹 Employee nach ID abrufen
```bash
curl -X GET http://localhost:8080/api/employees/1
```
Oder im Browser:
[http://localhost:8080/api/employees/1](http://localhost:8080/api/employees/1)

---

### 🔹 Neuen Employee hinzufügen

**POST**

```bash
curl -X POST http://localhost:8080/api/employees \
     -H "Content-Type: application/json" \
     -d '{
           "firstName": "Max",
           "lastName": "Mustermann",
           "email": "max@beispiel.com"
         }'
```
**In Postman:**
```
- Methode: `POST`  
- URL: `http://localhost:8080/api/employees`  
- Header: `Content-Type: application/json`  
- Body (raw / JSON):
```
```json
{
  "firstName": "Max",
  "lastName": "Mustermann",
  "email": "max@beispiel.com"
}
```

---

### 🔹 Bestehenden Employee aktualisieren

**PUT**

```bash
curl -X PUT http://localhost:8080/api/employees \
     -H "Content-Type: application/json" \
     -d '{
           "id": 1,
           "firstName": "Maximilian",
           "lastName": "Mustermann",
           "email": "max@beispiel.com"
         }'
```
**In Postman:**
- Methode: `PUT`  
- URL: `http://localhost:8080/api/employees`  
- Header: `Content-Type: application/json`  
- Body (raw / JSON):
- 
```json
{
  "id" : 1,
  "firstName": "Max",
  "lastName": "Mustermann",
  "email": "max@beispiel.com"
}
```
> ⚠️ **Wichtig:** Beim Aktualisieren muss die `id` im JSON-Body angegeben werden.

---

### 🔹 Employee löschen


**DELETE**

```bash
curl -X DELETE http://localhost:8080/api/employees/1
```
**In Postman:**
- Methode: `DELETE`  
- URL: `http://localhost:8080/api/employees/1`  
- Header: `Content-Type: application/json`  
- Body: *(leer)*
  
> 🗑️ Löscht den Employee mit der ID `1` dauerhaft aus der Datenbank.
