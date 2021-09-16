package com.sarpio.departmentservice.service;

import com.sarpio.departmentservice.entity.Departments;
import com.sarpio.departmentservice.repository.DepartmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DepartmentsService {

    private final DepartmentsRepository departmentsRepository;

    public Departments saveDepartment(Departments department) {
        return departmentsRepository.save(department);
    }

    public Departments findDepartmentById(Long departmentId) {
        return departmentsRepository
                .findById(departmentId)
                .orElseThrow(() -> new NoSuchElementException("There is no Department with ID: " + departmentId));
    }
    // spring calls after the initialization of bean properties
    @PostConstruct
    private void initDb() {
        Departments dep1 = new Departments();
        Departments dep2 = new Departments();
        Departments dep3 = new Departments();
        dep1.setDepartmentName("Software Development");
        dep1.setDepartmentCode("ITSD-1");
        dep2.setDepartmentName("IT Infrastructure");
        dep2.setDepartmentCode("ITID-2");
        dep3.setDepartmentName("IT NET Development");
        dep3.setDepartmentCode("ITSD-3");
        departmentsRepository.save(dep1);
        departmentsRepository.save(dep2);
        departmentsRepository.save(dep3);
    }
}
