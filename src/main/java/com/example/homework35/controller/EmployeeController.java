package com.example.homework35.controller;

import com.example.homework35.model.Employee;
import com.example.homework35.record.EmployeeRequest;
import com.example.homework35.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Map;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public Map<Integer, Employee> getEmployees() {
        return this.employeeService.getEmployees();
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
