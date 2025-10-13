package com.saglam.employeeapi.service;

import com.saglam.employeeapi.Repository.EmployeeRepository;
import com.saglam.employeeapi.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service-Klasse für Employee.
 *
 * Verantwortlich für die Geschäftslogik und den Zugriff auf das EmployeeRepository.
 *
 * Annotation:
 * @Service -> Kennzeichnet die Klasse als Spring-Service-Bean.
 */

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    // Konstruktorinjektion von EmployeeRepository
    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Employee findById(int id) {
        Optional<Employee> employee = employeeRepository.findById(id);

        if (employee.isPresent()) {
            return employee.get();
        } else {
            throw new RuntimeException("Did not find employee id - " + id);
        }
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

}
