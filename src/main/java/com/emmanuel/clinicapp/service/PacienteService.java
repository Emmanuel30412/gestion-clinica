package com.emmanuel.clinicapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emmanuel.clinicapp.model.Paciente;
import com.emmanuel.clinicapp.repository.PacienteRepository;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public List<Paciente> obtenerTodos(){
        return repository.findAll();
    }

    public Optional<Paciente> obtenerPorId(Long id) {
        return repository.findById(id);
    }

    public Paciente crear(Paciente paciente) {
        return repository.save(paciente);
    }

    public Paciente actualizar(Long id, Paciente datos) {
        return repository.findById(id).map(paciente -> {
            paciente.setNombre(datos.getNombre());
            paciente.setCorreo(datos.getCorreo());
            paciente.setTelefono(datos.getTelefono());   
            return repository.save(paciente);
        }).orElseThrow(()-> new RuntimeException("Paciente no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
    
}
