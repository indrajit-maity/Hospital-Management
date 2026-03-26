package com.HospitalManagement.ManagedHospital.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

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
    private LocalDate birthdate;
    @Column(nullable = false,unique = true)
    private String email;
    private String gender;
    private String disease;

    @CreationTimestamp
    @Column(updatable = true)
    private LocalDate createdAt;

    @Enumerated(EnumType.STRING)
    private Insurance insurance;
}
