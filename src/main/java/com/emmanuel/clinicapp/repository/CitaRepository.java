package com.emmanuel.clinicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emmanuel.clinicapp.model.Cita;

public interface CitaRepository  extends JpaRepository<Cita, Long>{
    

}
