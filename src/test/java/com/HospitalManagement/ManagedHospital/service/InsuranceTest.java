package com.HospitalManagement.ManagedHospital.service;


import com.HospitalManagement.ManagedHospital.entity.Insurance;
import com.HospitalManagement.ManagedHospital.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;


    @Test
    public void  testInsurance(){
        Insurance insurance=Insurance.builder()
                .policyNumber("HDFC_1234")
                .provider("Hdfc")
                .validUntil(LocalDate.of(2005,01,18))
                .build();
        Patient patient=insuranceService.assignInsurancetoPatient(insurance,12L);
        System.out.println(patient);
    }
}
