package com.HospitalManagement.ManagedHospital.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateAppointmentRequestDto {
    private  Long doctor_id;
    private  Long patient_id;
    private String reason;
    private LocalDateTime appointmentTime;
}
