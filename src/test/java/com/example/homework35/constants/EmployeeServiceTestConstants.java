package com.example.homework35.constants;

import com.example.homework35.model.Employee;
import com.example.homework35.record.EmployeeRequest;

import java.util.List;

public class EmployeeServiceTestConstants {

    public static final Integer KEY_NOT_EXIST = Integer.MAX_VALUE;
    public static final EmployeeRequest NULL_FIRST_NAME = new EmployeeRequest(null, "Ivanov", 1, 10000);
    public static final EmployeeRequest NULL_LAST_NAME = new EmployeeRequest("Ivan", null, 1, 10000);
    public static final EmployeeRequest ILLEGAL_CHARACTERS_FIRST_NAME = new EmployeeRequest("Ivan1", "Ivanov", 1, 10000);
    public static final EmployeeRequest ILLEGAL_CHARACTERS_LAST_NAME = new EmployeeRequest("Ivan", "Ivanov!!", 1, 10000);
    public static final EmployeeRequest IVAN_REQUEST = new EmployeeRequest("Ivan", "Ivanov", 1, 30000);
    public static final Employee IVAN = new Employee("Ivan", "Ivanov", 1, 30000);
    public static final EmployeeRequest PETR_REQUEST = new EmployeeRequest("Petr", "Petrov", 1, 10000);
    public static final Employee PETR = new Employee("Petr", "Petrov", 1, 10000);
    public static final EmployeeRequest NIKOLAY_REQUEST = new EmployeeRequest("Nikolay", "Nikolaev", 2, 25000);
    public static final Employee NIKOLAY = new Employee("Nikolay", "Nikolaev", 2, 25000);
    public static final EmployeeRequest VASILIY_REQUEST = new EmployeeRequest("Vasiliy", "Vasiliev", 2, 15000);
    public static final Employee VASILIY = new Employee("Vasiliy", "Vasiliev", 2, 15000);

    public static final List<Employee> EMPLOYEE_LIST = List.of(
            IVAN,
            PETR,
            NIKOLAY,
            VASILIY
    );

}
