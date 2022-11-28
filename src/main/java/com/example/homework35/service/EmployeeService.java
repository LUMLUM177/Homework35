package com.example.homework35.service;

import com.example.homework35.model.Employee;
import com.example.homework35.record.EmployeeRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private final Map<Integer, Employee> employees = new HashMap<>();

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public List<Employee> getEmployeesList() {
        List<Employee> employees = new ArrayList<>();
        for (Map.Entry<Integer, Employee> entry : getEmployees().entrySet()) {
            employees.add(entry.getValue());
        }
        return employees;
    }

    public double getSalarySum() {
        return employees.values().stream()
                .mapToDouble(Employee::getSalary)
                .sum();
    }

    public Employee getSalaryMin() {
        double min = Double.MAX_VALUE;
        int key = 0;
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (entry.getValue().getSalary() < min) {
                min = entry.getValue().getSalary();
                key = entry.getKey();
            }
        }
        return this.employees.get(key);
    }

    public Employee getSalaryMax() {
        double max = Double.MIN_VALUE;
        int key = 0;
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (entry.getValue().getSalary() > max) {
                max = entry.getValue().getSalary();
                key = entry.getKey();
            }
        }
        return this.employees.get(key);
    }

    public Collection<Employee> getAllEmployeesHighSalary() {
        Map<Integer, Employee> employeesHighSalary = new HashMap<>();
        for (Map.Entry<Integer, Employee> entry : employees.entrySet()) {
            if (entry.getValue().getSalary() > getAverageSum()) {
                employeesHighSalary.put(entry.getKey(), entry.getValue());
            }
        }
        return employeesHighSalary.values();
    }

    public double getAverageSum() {
        return getSalarySum() / employees.size();
    }

    public Employee addEmployee(EmployeeRequest employeeRequest) {
        if (employeeRequest.getFirstName() == null || employeeRequest.getLastName() == null) {
            throw new IllegalArgumentException("Employee name should be set");
        }
        if (!StringUtils.isAlpha(employeeRequest.getFirstName()) || !StringUtils.isAlpha(employeeRequest.getLastName())) {
            throw new RuntimeException("400 Bad Request");
        }
        Employee employee = new Employee(employeeRequest.getFirstName(),
                employeeRequest.getLastName(),
                employeeRequest.getDepartment(),
                employeeRequest.getSalary());

        this.employees.put(employee.getId(), employee);
        return employee;
    }

    public Collection<Employee> removeEmployee(Integer key) {
        if (!employees.containsKey(key)) {
            throw new RuntimeException("Сотрудника с таким номером не существует");
        }
        employees.remove(key, getEmployees().get(key));
        return this.employees.values();
    }

    public Employee findEmployee(Integer key) {
        for (int i = 0; i < getEmployeesList().size(); i++) {
            if (getEmployeesList().get(i).getId() == key) {
                Employee employee = new Employee(getEmployeesList().get(i).getFirstName(),
                        getEmployeesList().get(i).getLastName(),
                        getEmployeesList().get(i).getDepartment(),
                        getEmployeesList().get(i).getSalary()
                );
                return employee;
            }
        }
        throw new RuntimeException("Сотрудника с таким номером не существует");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeService that = (EmployeeService) o;
        return Objects.equals(employees, that.employees);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employees);
    }
}
