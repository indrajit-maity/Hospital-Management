package com.HospitalManagement.ManagedHospital.repositry;

import com.HospitalManagement.ManagedHospital.entity.Patient;
//import com.SpringBoot.HospitalManagement.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepositry extends JpaRepository<Patient,Long> {
   Optional<Patient> findById(Long id);

    List<Patient> findByNameAndDisease(String name, String fever);

    List<Patient> findByNameOrEmail(String name, String email);

    @Query("SELECT p FROM Patient p")
    Page<Patient> findAllPatients(Pageable pageable);

//    List<Patient> findByNameOrEmail(LocalDate of, String mail);

//    Optional<Patient> findByName(String name);

//    Patient findbyPhone(long phone);
}
