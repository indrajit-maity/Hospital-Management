package com.HospitalManagement.ManagedHospital.service;


import com.HospitalManagement.ManagedHospital.entity.Appointment;
import com.HospitalManagement.ManagedHospital.entity.Insurance;
import com.HospitalManagement.ManagedHospital.entity.Patient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private AppoinmentService appoinmentService;


    @Test
    public void  testInsurance(){
        Insurance insurance=Insurance.builder()
                .policyNumber("HDFC_1235")
                .provider("Hdfs")
                .validUntil(LocalDate.of(2005,01,18))
                .build();
        Patient patient=insuranceService.assignInsurancetoPatient(insurance,12L);
        System.out.println(patient);
    }


    @Test
    public void testAppoinment(){
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2005,01,18,1,23,50))
                .reason("Cancer")
                .build();
        Appointment newappoinment=appoinmentService.createnewAppointment(appointment,12L,1L);
        System.out.println(newappoinment);
    }
    @Test
    public void assigndoctor(){
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2005,01,18,1,23,50))
                .reason("Malaria")
                .build();
        Appointment newassgin=appoinmentService.reAssignappointmenttoAnotherDoctor(2L,1L);
        System.out.println(newassgin);
    }

    @Test
    public void removeInsurance(){
        Patient patient=insuranceService.diassociateInsurancefrompatient(12L);
        System.out.println(patient);
    }
}
