package com.example.OneToMany.College.repository;

import com.example.OneToMany.College.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyRepo extends JpaRepository<Faculty,Integer> {
    List<Faculty> findByDepartmentName(String departmentName);
}
