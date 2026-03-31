package com.HospitalManagement.ManagedHospital.repositry;

import com.HospitalManagement.ManagedHospital.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    @Query(value = "SELECT * FROM Doctor d",nativeQuery = true)
    Page<Doctor> findAllDoctor(Pageable pageable);
}