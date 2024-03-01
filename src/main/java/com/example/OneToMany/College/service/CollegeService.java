package com.example.OneToMany.College.service;

import com.example.OneToMany.College.model.College;
import com.example.OneToMany.College.repository.CollegeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CollegeService {
    @Autowired
    private final CollegeRepo collegeRepo;
    public CollegeService(CollegeRepo collegeRepo) {
        this.collegeRepo = collegeRepo;
    }
    public College addCollege(College college) {
        return collegeRepo.save(college);
    }

    public List<College> getAllColleges() {
        return collegeRepo.findAll();
    }

    public College getCollegeById(Long id) {
        Optional<College> collegeOptional = collegeRepo.findById(id);
        return collegeOptional.orElse(null);
    }

    public College getCollegeByName(String name) {
        return collegeRepo.findByName(name);
    }

    public College updateCollegeName(Long id,String name) {
        Optional<College> collegeOptional = collegeRepo.findById(id);
        if (collegeOptional.isPresent()) {
            College college = collegeOptional.get();
            college.setName(name);
            return collegeRepo.save(college);
        }
        return null;
    }

    public void deleteCollegeById(int id) {
        collegeRepo.deleteById(id);
    }
}


















