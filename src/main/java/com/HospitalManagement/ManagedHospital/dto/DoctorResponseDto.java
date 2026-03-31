package com.HospitalManagement.ManagedHospital.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DoctorResponseDto {
    private Long id;
    private  String name;
    private  String specalization;
    private String email;

}
