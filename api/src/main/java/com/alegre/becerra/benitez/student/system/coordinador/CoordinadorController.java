package com.alegre.becerra.benitez.student.system.coordinador;

import com.alegre.becerra.benitez.student.system.DTO.CoordinadorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/coordinadores")
public class CoordinadorController {

    private final CoordinadorService coordinadorService;

    @Autowired
    public CoordinadorController(CoordinadorService coordinadorService) {
        this.coordinadorService = coordinadorService;
    }

    // Obtener todos los coordinadores
    @GetMapping
    public ResponseEntity<List<CoordinadorDTO>> getCoordinadores() {
        List<CoordinadorDTO> coordinadores = coordinadorService.getAllCoordinadores();
        return ResponseEntity.ok(coordinadores);
    }

    // Obtener un coordinador por ID
    @GetMapping("/{id}")
    public ResponseEntity<Coordinador> getCoordinadorById(@PathVariable UUID id) {
        Optional<Coordinador> coordinador = coordinadorService.getCoordinadorById(id);
        return coordinador.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo coordinador
    @PostMapping
    public Coordinador createCoordinador(@RequestBody Coordinador coordinador) {
        return coordinadorService.createCoordinador(coordinador);
    }

    // Actualizar un coordinador existente
    @PutMapping("/{id}")
    public ResponseEntity<Coordinador> updateCoordinador(@PathVariable UUID id, @RequestBody Coordinador coordinador) {
        return ResponseEntity.ok(coordinadorService.updateCoordinador(id, coordinador));
    }

    // Eliminar un coordinador por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCoordinador(@PathVariable UUID id) {
        coordinadorService.deleteCoordinador(id);
        return ResponseEntity.noContent().build();
    }

    // Asignar un coordinador a una carrera
    @PostMapping("/{coordinadorId}/asignar-carrera/{carreraId}")
    public ResponseEntity<Coordinador> asignarCoordinadorACarrera(
            @PathVariable UUID coordinadorId, @PathVariable UUID carreraId) {
        Coordinador coordinador = coordinadorService.asignarCoordinadorACarrera(coordinadorId, carreraId);
        return ResponseEntity.ok(coordinador);
    }
}
