package com.sarpio.departmentservice.controller;

import com.sarpio.departmentservice.entity.Departments;
import com.sarpio.departmentservice.service.DepartmentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/departments")
public class DepartmentsController {

    private final DepartmentsService departmentsService;

    @PostMapping("/")
    public Departments saveDepartment(@RequestBody Departments department) {
        return departmentsService.saveDepartment(department);
    }

    @GetMapping("/{id}")
    public Departments findDepartmentById(@PathVariable("id") Long departmentId) {
        return departmentsService.findDepartmentById(departmentId);
    }
}
