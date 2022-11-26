package com.example.homework35.controller;

import com.example.homework35.model.Employee;
import com.example.homework35.record.EmployeeRequest;
import com.example.homework35.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Collection<Employee> getAllEmployees() {
        return this.employeeService.getAllEmployees();
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeRequest employeeRequest) {
        return this.employeeService.addEmployee(employeeRequest);
    }

    @GetMapping("/employees/salary/sum")
    public double getSalarySum() {
        return this.employeeService.getSalarySum();
    }

    @GetMapping("/employee/salary/min")
    public Employee getSalaryMin() {
        return this.employeeService.getSalaryMin();
    }

    @GetMapping("/employee/salary/max")
    public Employee getSalaryMax() {
        return this.employeeService.getSalaryMax();
    }

    @GetMapping("/employees/high-salary")
    public Collection<Employee> getAllEmployeesHighSalary() {
        return this.employeeService.getAllEmployeesHighSalary();
    }

    @GetMapping("/employees/salary/averagesum")
    public double getAverageSum() {
        return this.employeeService.getAverageSum();
    }
}
