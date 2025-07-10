package com.emmanuel.clinicapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.emmanuel.clinicapp.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

     boolean existsByCorreo(String correo);
}
