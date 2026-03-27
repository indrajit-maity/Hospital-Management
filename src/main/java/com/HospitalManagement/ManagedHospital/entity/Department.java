package com.HospitalManagement.ManagedHospital.entity;


import jakarta.persistence.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 100)
    private String name;
    @OneToOne
    private Doctor headDoctor;


    @ManyToMany
    @JoinTable(
            name = "DoctorDepartment",
            joinColumns = @JoinColumn(name = "dept_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    private Set<Doctor> doctors=new HashSet<>();
}
