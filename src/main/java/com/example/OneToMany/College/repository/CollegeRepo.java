package com.example.OneToMany.College.repository;

import com.example.OneToMany.College.model.College;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CollegeRepo extends JpaRepository<College,Integer> {
    Optional<College> findById(Long id);

    College findByName(String name);
}
