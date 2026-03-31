package com.HospitalManagement.ManagedHospital.repositry;

import com.HospitalManagement.ManagedHospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}