package com.HospitalManagement.ManagedHospital.service;


import com.HospitalManagement.ManagedHospital.dto.PatientDto;
import com.HospitalManagement.ManagedHospital.entity.Patient;
import com.HospitalManagement.ManagedHospital.repositry.PatientRepositry;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final ModelMapper modelMapper;
    private final PatientRepositry patientRepositry;

    public PatientDto getById(Long id){
        Patient patient=patientRepositry.findById(id).orElseThrow();
        return modelMapper.map(patient,PatientDto.class);
    }

    public PatientDto createnewPatient(PatientDto patientDto) {
        Patient newpatient=modelMapper.map(patientDto,Patient.class);
        Patient patient=patientRepositry.save(newpatient);
        return modelMapper.map(patient,PatientDto.class);
    }

    public  List<Patient> getallpatient() {
        List<Patient> patients=patientRepositry.findAll();
        return patients.stream().toList();
    }
}
