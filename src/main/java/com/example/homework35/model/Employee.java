package com.example.homework35.model;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class Employee {
    private static final AtomicInteger COUNTER = new AtomicInteger(1);

    private final int id;
    private final String firstName;
    private final String lastName;
    private int department;
    private double salary;

    public Employee(String firstName, String lastName, int department, double salary) {
        id = COUNTER.getAndIncrement();
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(int department) {
        this.department = department;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return department == employee.department && Double.compare(employee.salary, salary) == 0 && Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, department, salary);
    }

    public String toString() {
        return id + ": " + firstName + " " + lastName + " работает в " + department + " отделе, зарплата составляет " + salary + " рублей.";
    }


}