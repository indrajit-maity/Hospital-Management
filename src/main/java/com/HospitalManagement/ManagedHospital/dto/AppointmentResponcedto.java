package com.HospitalManagement.ManagedHospital.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AppointmentResponcedto {
    private Long id;
    private LocalDateTime localDateTime;
    private String reason;
    private DoctorResponseDto doctor;
//    private  PatientResponseDto patient;
}
