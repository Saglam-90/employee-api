package com.saglam.employeeapi.Repository;

import com.saglam.employeeapi.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * EmployeeRepository-Interface.
 *
 * Dieses Interface ermöglicht CRUD-Operationen (Create, Read, Update, Delete)
 * für die Employee-Entity, ohne dass wir die Methoden selbst implementieren müssen.
 *
 * Es erbt von JpaRepository<Employee, Integer>:
 * - Employee: die Entity-Klasse, auf die sich das Repository bezieht
 * - Integer: der Typ des Primärschlüssels der Entity
 *
 * Dank Spring Data JPA stehen uns automatisch viele Methoden zur Verfügung,
 * z. B. save(), findById(), findAll(), deleteById() usw.
 */

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
