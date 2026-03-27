package com.HospitalManagement.ManagedHospital.entity;

import com.HospitalManagement.ManagedHospital.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@ToString
@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
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
    private BloodGroupType bloodGroup;

    @OneToOne(cascade = {CascadeType.ALL},orphanRemoval = true)//owning side
    @JoinColumn(name = "patient_insurance_id")
    private Insurance insurance;


    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private List<Appointment> appointments=new ArrayList<>();

}
