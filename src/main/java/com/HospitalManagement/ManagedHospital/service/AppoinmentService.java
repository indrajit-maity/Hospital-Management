package com.HospitalManagement.ManagedHospital.service;

import com.HospitalManagement.ManagedHospital.entity.Appointment;
import com.HospitalManagement.ManagedHospital.entity.Doctor;
import com.HospitalManagement.ManagedHospital.entity.Patient;
import com.HospitalManagement.ManagedHospital.repositry.AppointmentRepository;
import com.HospitalManagement.ManagedHospital.repositry.DoctorRepository;
import com.HospitalManagement.ManagedHospital.repositry.PatientRepositry;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppoinmentService {
    private  final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepositry patientRepositry;

    @Transactional
    public Appointment createnewAppointment(Appointment appointment,Long patient_id,Long doctor_id){
        Doctor doctor=doctorRepository.findById(doctor_id).orElseThrow(()->new IllegalArgumentException("Doctor is not exits eith this id: "+ doctor_id));
        Patient patient=patientRepositry.findById(patient_id).orElseThrow(()->new IllegalArgumentException("Patient is not exits with this id: "+patient_id));
        if(appointment.getId()!=null) throw  new IllegalArgumentException("Appointment should not have ID.");
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointments().add(appointment);//getAppoinments add a appoinments to the existing list//this is for bi dirctional case
//        patient.setAppointments(appointment);//setAppoinments replaces the whole existing list
        Appointment newappoinment= appointmentRepository.save(appointment);
        return newappoinment;
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
