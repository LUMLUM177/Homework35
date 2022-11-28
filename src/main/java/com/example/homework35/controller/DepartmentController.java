package com.example.homework35.controller;

import com.example.homework35.model.Employee;
import com.example.homework35.service.DepartmentService;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/department/employees")
    @ResponseBody
    public Collection<Employee> getAllEmployeesInDepartment(@RequestParam int id) {
        return this.departmentService.getAllEmployeesInDepartment(id);
    }

    @GetMapping("/department/allemployees")
    @ResponseBody
    public Map<Integer, List<Employee>> getAllEmployeesInDepartment() {
        return this.departmentService.getAllEmployees();
    }

    @GetMapping("/department/salary/sum")
    @ResponseBody
    public double getSalarySum(@RequestParam int id) {
        return this.departmentService.getSalarySumInDepartment(id);
    }

    @GetMapping("/department/salary/max")
    @ResponseBody
    public double getSalaryMax(@RequestParam int id) {
        return this.departmentService.getSalaryMaxInDepartment(id);
    }

    @GetMapping("/department/salary/min")
    @ResponseBody
    public double getSalaryMin(@RequestParam int id) {
        return this.departmentService.getSalaryMinInDepartment(id);
    }
}
