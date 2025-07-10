package com.emmanuel.clinicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.emmanuel.clinicapp.model.Paciente;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    boolean existsByCorreo(String correo);

}
