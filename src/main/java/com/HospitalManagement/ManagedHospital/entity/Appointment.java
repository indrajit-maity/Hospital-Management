package com.HospitalManagement.ManagedHospital.entity;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@ToString
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime appointmentTime;

    @Column(length = 500)
    private String reason;

    @ManyToOne
    @JoinColumn(name = "patient_id",nullable = false)
    private Patient patient;


    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false)
    private Doctor doctor;
}
