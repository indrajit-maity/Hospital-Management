package com.HospitalManagement.ManagedHospital.configaration;


import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfigaration {
    @Bean
    public ModelMapper modelMapper(){

        return new ModelMapper();
    }
}
