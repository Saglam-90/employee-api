package com.saglam.employeeapi.controller;

import com.saglam.employeeapi.entity.Employee;
import com.saglam.employeeapi.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für Employee.
 * Basis-URL: /api
 */
@RestController()
@RequestMapping("/api")
@Tag(name = "Employee Management", description = "CRUD APIs für Mitarbeiter-Verwaltung")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Alle Mitarbeiter abrufen", description = "Liefert eine Liste aller Mitarbeiter")
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @Operation(summary = "Mitarbeiter nach ID finden", description = "Such einen Mitarbeiter anhand der ID")
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {

        return employeeService.findById(employeeId);
    }

    @Operation(summary = "Neuen Mitarbeiter erstellen", description = "Erstellt einen neuen Mitarbeiter in der Datenbank")
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(null);

        return employeeService.save(employee);
    }

    @Operation(summary = "Mitarbeiter aktualisieren", description = "Aktualisiert einen bestehenden Mitarbeiter")
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    @Operation(summary = "Mitarbeiter löschen", description = "Löscht einen Mitarbeiter anhand der ID")
    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable int employeeId) {

        employeeService.deleteById(employeeId);

        return "deleted employee with id - " + employeeId;
    }
}
