package com.HospitalManagement.ManagedHospital.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Builder
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DoctorDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
