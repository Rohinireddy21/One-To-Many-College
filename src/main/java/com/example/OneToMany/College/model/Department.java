package com.example.OneToMany.College.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "college_id", nullable = false)
    private College college;


    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Faculty> faculties = new ArrayList<>();

}


