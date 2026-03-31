package com.HospitalManagement.ManagedHospital.controller;


import com.HospitalManagement.ManagedHospital.dto.DoctorResponseDto;
import com.HospitalManagement.ManagedHospital.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hospital")
public class HospitalController {

    private final DoctorService doctorService;

    @GetMapping("/doctors")
    public ResponseEntity<List<DoctorResponseDto>> getAllDoctor(
            @RequestParam(value = "page",defaultValue = "0") Integer pageNumber,
            @RequestParam(value="size",defaultValue = "5") Integer size
    ){
        return ResponseEntity.status(HttpStatus.CREATED).body(doctorService.getAllDoctors(pageNumber,size));
    }


}
