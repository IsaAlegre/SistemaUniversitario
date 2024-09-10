package com.alegre.becerra.benitez.student.system.estado.actual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/estado-alumno")
public class EstadoActualController {

    @Autowired
    private EstadoActualService estadoActualService;

    // Obtener el estado de un alumno por UUID
    @GetMapping("/{uuid}")
    public ResponseEntity<EstadoActual> obtenerEstadoActual(@PathVariable UUID uuid) {
        Optional<EstadoActual> estadoActual = estadoActualService.obtenerEstadoActualPorUuid(uuid);
        return estadoActual.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar el estado y/o inasistencias del alumno
    @PutMapping("/{uuid}")
    public ResponseEntity<EstadoActual> actualizarEstadoYInasistencias(
            @PathVariable UUID uuid,
            @RequestParam(value = "estado", required = false) String nuevoEstado,
            @RequestParam(value = "inasistencias", required = false) Integer nuevasInasistencias) {

        EstadoActual estadoActualActualizado = estadoActualService
                .actualizarEstadoYInasistencias(uuid, nuevoEstado, nuevasInasistencias);

        return ResponseEntity.ok(estadoActualActualizado);
    }
}
