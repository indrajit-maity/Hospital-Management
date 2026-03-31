package com.HospitalManagement.ManagedHospital.service;

import com.HospitalManagement.ManagedHospital.dto.AppointmentResponcedto;
import com.HospitalManagement.ManagedHospital.dto.CreateAppointmentRequestDto;
import com.HospitalManagement.ManagedHospital.entity.Appointment;
import com.HospitalManagement.ManagedHospital.entity.Doctor;
import com.HospitalManagement.ManagedHospital.entity.Patient;
import com.HospitalManagement.ManagedHospital.repositry.AppointmentRepository;
import com.HospitalManagement.ManagedHospital.repositry.DoctorRepository;
import com.HospitalManagement.ManagedHospital.repositry.PatientRepositry;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppoinmentService {
    private  final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepositry patientRepositry;
    private final ModelMapper modelMapper;

    @Transactional
    public AppointmentResponcedto createnewAppointment(CreateAppointmentRequestDto createAppointmentRequestDto){
        Long doctorId= createAppointmentRequestDto.getDoctor_id();
        Long patientId= createAppointmentRequestDto.getPatient_id();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow(()->new IllegalArgumentException("Doctor Are not exits with this id:"+doctorId));
        Patient patient=patientRepositry.findById(patientId).orElseThrow(()->new IllegalArgumentException("Patient is not exits with this id:"+ patientId));
        Appointment appointment=Appointment.builder()
                .reason(createAppointmentRequestDto.getReason())
                .appointmentTime(createAppointmentRequestDto.getAppointmentTime())
                .build();
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointments().add(appointment);
        Appointment newappointment=appointmentRepository.save(appointment);
        return modelMapper.map(newappointment, AppointmentResponcedto.class);
    }

    @Transactional
    public Appointment reAssignappointmenttoAnotherDoctor(Long appointment_id,Long doctor_id){
        Appointment appointment=appointmentRepository.findById(appointment_id).orElseThrow(()->new IllegalArgumentException("Appointment is not exits with this id: "+appointment_id));
        Doctor doctor=doctorRepository.findById(doctor_id).orElseThrow(()->new IllegalArgumentException("This doctor is not present in db."));
        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment);
        return appointment;
    }
}
