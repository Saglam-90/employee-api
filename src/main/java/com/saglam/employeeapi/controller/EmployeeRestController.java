package com.saglam.employeeapi.controller;

import com.saglam.employeeapi.entity.Employee;
import com.saglam.employeeapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST-Controller für Employee.
 * Basis-URL: /api
 */
@RestController()
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // GET /api/employees - alle Employees
    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    // GET /api/employees/{id} - Employee anhand der ID
    @GetMapping("/employees/{employeeId}")
    public Employee findById(@PathVariable int employeeId) {

        return employeeService.findById(employeeId);
    }

    // POST /api/employees - neuen Employee hinzufügen
    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee) {

        employee.setId(null);

        return employeeService.save(employee);
    }

    // PUT /api/employees - bestehenden Employee aktualisieren
    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        return employeeService.save(employee);
    }

    // DELETE /api/employees/{id} - Employee löschen
    @DeleteMapping("/employees/{employeeId}")
    public String deleteById(@PathVariable int employeeId) {

        employeeService.deleteById(employeeId);

        return "deleted employee with id - " + employeeId;
    }
}
