package com.example.OneToMany.College.model;

import jakarta.persistence.*;

@Entity
@Table(name = "faculty")

public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;


}
