package com.HospitalManagement.ManagedHospital.repositry;

import com.HospitalManagement.ManagedHospital.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.lang.ScopedValue;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String userName);
}