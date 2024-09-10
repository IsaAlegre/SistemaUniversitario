package com.alegre.becerra.benitez.student.system.estado.actual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Service
public class EstadoActualService {

    @Autowired
    private EstadoActualRepositorio estadoActualRepositorio;

    // Obtener el estado del alumno por UUID
    public Optional<EstadoActual> obtenerEstadoActualPorUuid(UUID uuid) {
        return estadoActualRepositorio.findById(uuid);
    }

    // Modificar las inasistencias y el estado del alumno (pueden ser juntas o por separado)
    @Transactional
    public EstadoActual actualizarEstadoYInasistencias(UUID uuid, String nuevoEstado, Integer nuevasInasistencias) {
        EstadoActual estadoActual = estadoActualRepositorio.findById(uuid)
                .orElseThrow(() -> new RuntimeException("EstadoActual no encontrado para el UUID: " + uuid));

        // Modificar el estado si se proporciona un nuevo valor
        if (nuevoEstado != null) {
            estadoActual.setEstado(nuevoEstado);
        }

        // Modificar las inasistencias si se proporciona un nuevo valor
        if (nuevasInasistencias != null) {
            estadoActual.setInasistencias(nuevasInasistencias);
        }

        // Guardar y devolver el estado actualizado
        return estadoActualRepositorio.save(estadoActual);
    }
}
