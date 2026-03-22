package com.HospitalManagement.ManagedHospital.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;


@ToString
@Entity
@Getter
@Setter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;

//    @ToString.Exclude
    private String disease;
    private long phone;
    private LocalDate birthdate;
    @Column(nullable = false,unique = true)
    private String email;
//    private String gender;
}
