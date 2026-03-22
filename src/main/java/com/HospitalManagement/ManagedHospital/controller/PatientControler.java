package com.HospitalManagement.ManagedHospital.controller;

import com.HospitalManagement.ManagedHospital.dto.PatientDto;
import com.HospitalManagement.ManagedHospital.entity.Patient;
import com.HospitalManagement.ManagedHospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/hospital")
public class PatientControler {

    public final PatientService patientService;

    @GetMapping
    public ResponseEntity<List<Patient>> getAllpatient(){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.getallpatient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getbyid(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.CREATED).body(patientService.getById(id));
    }


    @PostMapping
    public ResponseEntity<PatientDto> Addpatient(@RequestBody PatientDto patientDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createnewPatient(patientDto));
    }
}
