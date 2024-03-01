package com.example.OneToMany.College.repository;

import com.example.OneToMany.College.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepo extends JpaRepository<Department,Integer> {
    List<Department> findByCollegeName(String collegeName);
}
