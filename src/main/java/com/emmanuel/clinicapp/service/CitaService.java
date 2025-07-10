package com.emmanuel.clinicapp.service;

import com.emmanuel.clinicapp.model.Cita;
import com.emmanuel.clinicapp.model.Medico;
import com.emmanuel.clinicapp.model.Paciente;
import com.emmanuel.clinicapp.repository.CitaRepository;
import com.emmanuel.clinicapp.repository.MedicoRepository;
import com.emmanuel.clinicapp.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitaService {

    private final CitaRepository citaRepo;
    private final PacienteRepository pacienteRepo;
    private final MedicoRepository medicoRepo;

    public CitaService(CitaRepository citaRepo, PacienteRepository pacienteRepo, MedicoRepository medicoRepo) {
        this.citaRepo = citaRepo;
        this.pacienteRepo = pacienteRepo;
        this.medicoRepo = medicoRepo;
    }

    public List<Cita> obtenerTodas() {
        return citaRepo.findAll();
    }

    public Cita crear(Long pacienteId, Long medicoId, Cita cita) {
        Paciente paciente = pacienteRepo.findById(pacienteId)
            .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Medico medico = medicoRepo.findById(medicoId)
            .orElseThrow(() -> new RuntimeException("Médico no encontrado"));

        cita.setPaciente(paciente);
        cita.setMedico(medico);

        return citaRepo.save(cita);
    }

    public void eliminar(Long id) {
        citaRepo.deleteById(id);
    }
}
