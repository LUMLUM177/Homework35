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

    public List<Employee> getAllEmployeesInDepartmentToList(int id) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < employeeService.getEmployeesList().size(); i++) {
            if (employeeService.getEmployeesList().get(i).getDepartment() == id) {
                employees.add(employeeService.getEmployeesList().get(i));
            }
        }
        if (employees.size() == 0) {
            throw new RuntimeException("Сотрудников в этом департаменте нет!");
        }
        return employees;
    }

    public double getSalarySumInDepartment(int id) {
        double sum = 0;
        for (int i = 0; i < employeeService.getEmployeesList().size(); i++) {
            if (employeeService.getEmployeesList().get(i).getDepartment() == id) {
                sum += employeeService.getEmployeesList().get(i).getSalary();
            }
        }
        return sum;
    }

    public double getSalaryMaxInDepartment(int id) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < employeeService.getEmployeesList().size(); i++) {
            if (employeeService.getEmployeesList().get(i).getDepartment() == id &&
                    employeeService.getEmployeesList().get(i).getSalary() > max) {
                max = employeeService.getEmployeesList().get(i).getSalary();
            }
        }
        return max;
    }

    public double getSalaryMinInDepartment(int id) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < employeeService.getEmployeesList().size(); i++) {
            if (employeeService.getEmployeesList().get(i).getDepartment() == id &&
                    employeeService.getEmployeesList().get(i).getSalary() < min) {
                min = employeeService.getEmployeesList().get(i).getSalary();
            }
        }
        return min;
    }

    public Map<Integer, List<Employee>> getAllEmployees() {
        Map<Integer, List<Employee>> employeesInDepartment = new HashMap<>();
        for (int i = 0; i < employeeService.getEmployeesList().size(); i++) {
            List<Employee> employees = new ArrayList<>();
            if (employeesInDepartment.containsKey(employeeService.getEmployeesList().get(i).getDepartment())) {
                employees = employeesInDepartment.get(employeeService.getEmployeesList().get(i).getDepartment());
            }
            employees.add(employeeService.getEmployeesList().get(i));
            employeesInDepartment.put(employeeService.getEmployeesList().get(i).getDepartment(), employees);
        }
        return employeesInDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartmentService that = (DepartmentService) o;
        return Objects.equals(employeeService, that.employeeService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeService);
    }
}
