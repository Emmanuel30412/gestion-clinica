package com.emmanuel.clinicapp.controller;

import com.emmanuel.clinicapp.model.Cita;
import com.emmanuel.clinicapp.service.CitaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    private final CitaService service;

    public CitaController(CitaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Cita> listar() {
        return service.obtenerTodas();
    }

    @PostMapping("/paciente/{pacienteId}/medico/{medicoId}")
    public ResponseEntity<Cita> crear(
            @PathVariable Long pacienteId,
            @PathVariable Long medicoId,
            @Valid @RequestBody Cita cita) {
        Cita nueva = service.crear(pacienteId, medicoId, cita);
        return ResponseEntity.status(201).body(nueva);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
