package com.HospitalManagement.ManagedHospital.service;

import com.HospitalManagement.ManagedHospital.dto.PatientDto;
import com.HospitalManagement.ManagedHospital.entity.Patient;
import com.HospitalManagement.ManagedHospital.repositry.PatientRepositry;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

//import static org.springframework.test.util.AssertionErrors.assertNotNull;

//@RequiredArgsConstructor
@SpringBootTest
class PatientServiceTest {
    @Autowired
    PatientRepositry patientRepositry;
   @Autowired
     PatientService service;
  @Test
    public void add(){
        int val=2+3;
        System.out.println(val);
        System.out.println("Hello World");
    }
    @Test
    void getById() {
    }

    @Test
    void createnewPatient() {
        PatientDto patientdto=new PatientDto();
        patientdto.setName("Laltu");
        patientdto.setDisease("fever");
        patientdto.setPhone(878567L);
        PatientDto patientDto=service.createnewPatient(patientdto);
        assertNotNull(patientDto);
    }
    @Test
    public void testQuery(){
//     Optional<Patient> patient=patientRepositry.findById(12L);
//        Patient p=patient.get();
//        System.out.println(p.getName());
//        System.out.println(p.getDisease());
//        System.out.println(p.getPhone());
//        System.out.println(p.getId());
//        List<Patient> patientList=patientRepositry.findByNameAndDisease("Indrajit Maity","fever");
//        for(Patient patient1:patientList){
//            System.out.println(patient1.toString());
//        }

//        List<Patient> patients=patientRepositry.findByNameOrEmail("Kamal Maity","2005indrajitmaity@gmail.com");
//        System.out.println(patients);

        Page<Patient> patients=patientRepositry.findAllPatients(PageRequest.of(0,5, Sort.by("name")));
        for(Patient patient1:patients){
            System.out.println(patient1);
        }

    }

    @Test
    void getallpatient() {
      List<Patient> patientList=patientRepositry.findAll();
      System.out.println(patientList);
    }
}