package com.HospitalManagement.ManagedHospital.controller;

import com.HospitalManagement.ManagedHospital.dto.AppointmentResponcedto;
import com.HospitalManagement.ManagedHospital.dto.CreateAppointmentRequestDto;
import com.HospitalManagement.ManagedHospital.dto.PatientDto;
import com.HospitalManagement.ManagedHospital.entity.Patient;
import com.HospitalManagement.ManagedHospital.service.AppoinmentService;
import com.HospitalManagement.ManagedHospital.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientControler {

    private final PatientService patientService;
    private final AppoinmentService appoinmentService;

    @GetMapping("/all")
    public ResponseEntity<List<Patient>> getAllpatient(){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.getallpatient());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PatientDto> getbyid(@PathVariable Long id){
        return  ResponseEntity.status(HttpStatus.CREATED).body(patientService.getById(id));
    }


    @PostMapping("/newPatient")
    public ResponseEntity<PatientDto> Addpatient(@RequestBody PatientDto patientDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(patientService.createnewPatient(patientDto));
    }

    @PostMapping("/newAppointment")
    public ResponseEntity<AppointmentResponcedto> createAppointment(@RequestBody CreateAppointmentRequestDto createAppointmentRequestDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(appoinmentService.createnewAppointment(createAppointmentRequestDto));
    }

}
