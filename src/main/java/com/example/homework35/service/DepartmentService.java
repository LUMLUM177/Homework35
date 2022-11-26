package com.example.homework35.service;

import com.example.homework35.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Collection<Employee> getAllEmployeesInDepartment(int id) {
        Map<Integer, Employee> employeesInDepartment = new HashMap<>();
        for (Map.Entry<Integer, Employee> entry : employeeService.getEmployees().entrySet()) {
            if (entry.getValue().getDepartment() == id) {
                employeesInDepartment.put(entry.getKey(), entry.getValue());
            }
        }
        if (employeesInDepartment.size() == 0) {
            throw new RuntimeException("Сотрудников в этом департаменте нет!");
        }
        return employeesInDepartment.values();
    }

    public double getSalarySumInDepartment(int id) {
        double sum = 0;
        for (Map.Entry<Integer, Employee> entry : employeeService.getEmployees().entrySet()) {
            if (entry.getValue().getDepartment() == id) {
                sum += entry.getValue().getSalary();
            }
        }
        return sum;
    }

    public double getSalaryMaxInDepartment(int id) {
        double max = Double.MIN_VALUE;
        for (Map.Entry<Integer, Employee> entry : employeeService.getEmployees().entrySet()) {
            if (entry.getValue().getDepartment() == id && entry.getValue().getSalary() > max) {
                max = entry.getValue().getSalary();
            }
        }
        return max;
    }

    public double getSalaryMinInDepartment(int id) {
        double min = Double.MAX_VALUE;
        for (Map.Entry<Integer, Employee> entry : employeeService.getEmployees().entrySet()) {
            if (entry.getValue().getDepartment() == id && entry.getValue().getSalary() < min) {
                min = entry.getValue().getSalary();
            }
        }
        return min;
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        Map<Integer, List<Employee>> employeesInDepartment = new HashMap<>();
        for (Map.Entry<Integer, Employee> entry : employeeService.getEmployees().entrySet()) {
            List<Employee> employees = new ArrayList<>();
            if (employeesInDepartment.containsKey(entry.getValue().getDepartment())) {
                employees = employeesInDepartment.get(entry.getValue().getDepartment());
            }
            employees.add(entry.getValue());
            employeesInDepartment.put(entry.getValue().getDepartment(), employees);
        }
        return employeesInDepartment;
    }
}
