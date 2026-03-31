package com.HospitalManagement.ManagedHospital.dto;


import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OnboardDoctorRequestDto {
    private  Long userId;
    private String specalization;
    private String name;
}
