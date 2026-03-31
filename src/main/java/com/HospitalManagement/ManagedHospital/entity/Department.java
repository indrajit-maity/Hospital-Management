package com.HospitalManagement.ManagedHospital.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Builder
//@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true,length = 100)
    private String name;

    @OneToOne
    @JoinColumn(name = "head_doctor_id")
    private Doctor headDoctor;


    @ManyToMany
    @JoinTable(
            name = "DoctorDepartment",
            joinColumns = @JoinColumn(name = "dept_id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id")
    )
    @Builder.Default
    private Set<Doctor> doctors=new HashSet<>();
}
