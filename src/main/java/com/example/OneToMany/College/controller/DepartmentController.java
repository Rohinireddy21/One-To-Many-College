package com.example.OneToMany.College.controller;


import com.example.OneToMany.College.model.Department;
import com.example.OneToMany.College.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private final DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping
    public ResponseEntity<Department> addDepartment(@RequestBody Department department) {
        Department createdDepartment = departmentService.addDepartment(department);
        return new ResponseEntity<>(createdDepartment, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentService.getAllDepartments();
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable int id) {
        Department department = departmentService.getDepartmentById(id);
        return new ResponseEntity<>(department, HttpStatus.OK);
    }

    @GetMapping("/college/{collegeName}")
    public ResponseEntity<List<Department>> getDepartmentsByCollegeName(@PathVariable String collegeName) {
        List<Department> departments = departmentService.getDepartmentsByCollegeName(collegeName);
        return new ResponseEntity<>(departments, HttpStatus.OK);
    }

    @PostMapping("/{departmentId}/assignFaculty/{facultyId}")
    public ResponseEntity<Void> assignFacultyToDepartment(@PathVariable int departmentId, @PathVariable int facultyId) {
        departmentService.assignFacultyToDepartment(departmentId, facultyId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}