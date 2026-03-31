package com.HospitalManagement.ManagedHospital.entity;

import com.HospitalManagement.ManagedHospital.entity.type.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(unique = true,nullable = false)
    private String userName;
    private String password;

    private String Providerid;

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
            @Builder.Default
    Set<RoleType> roles=new HashSet<>();



}
