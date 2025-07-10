package com.emmanuel.clinicapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.emmanuel.clinicapp.model.Medico;
import com.emmanuel.clinicapp.repository.MedicoRepository;

@Service
public class MedicoService {
    
    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

      public List<Medico> obtenerTodos() {
        return repository.findAll();
    }

    public Optional<Medico> obtenerPorId(Long id) {
       return repository.findById(id);
    }

    public Medico crear(Medico medico) {
        return repository.save(medico);
    }

    public Medico actualizar(Long id, Medico datos) {
        return repository.findById(id).map(medico -> {
            medico.setNombre(datos.getNombre());
            medico.setCorreo(datos.getCorreo());
            medico.setEspecialidad(datos.getEspecialidad());
            return repository.save(medico);
        }).orElseThrow(()-> new RuntimeException("Medico no encontrado"));
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }


}
