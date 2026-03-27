package com.HospitalManagement.ManagedHospital.service;


import com.HospitalManagement.ManagedHospital.entity.Insurance;
import com.HospitalManagement.ManagedHospital.entity.Patient;
import com.HospitalManagement.ManagedHospital.repositry.InsuranceRepository;
import com.HospitalManagement.ManagedHospital.repositry.PatientRepositry;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepositry patientRepositry;


    @Transactional
    public Patient assignInsurancetoPatient(Insurance insurance,Long patientid){
        Patient patient=patientRepositry.findById(patientid)
                .orElseThrow(()->new EntityNotFoundException("Patient not found with id: " + patientid));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;
    }

}
