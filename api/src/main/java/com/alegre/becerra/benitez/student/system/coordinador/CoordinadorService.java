package com.alegre.becerra.benitez.student.system.coordinador;

import com.alegre.becerra.benitez.student.system.carrera.Carrera;
import com.alegre.becerra.benitez.student.system.carrera.CarreraRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CoordinadorService {
    private final CoordinadorRepositorio coordinadorRepositorio;
    private final CarreraRepositorio carreraRepositorio;

    @Autowired
    public CoordinadorService(CoordinadorRepositorio coordinadorRepositorio, CarreraRepositorio carreraRepositorio) {
        this.coordinadorRepositorio = coordinadorRepositorio;
        this.carreraRepositorio = carreraRepositorio;
    }

    // Obtener todos los coordinadores
    public List<Coordinador> getAllCoordinadores() {
        return coordinadorRepositorio.findAll();
    }

    // Obtener un coordinador por ID
    public Optional<Coordinador> getCoordinadorById(UUID id) {
        return coordinadorRepositorio.findById(id);
    }

    // Crear un nuevo coordinador
    public Coordinador createCoordinador(Coordinador coordinador) {
        return coordinadorRepositorio.save(coordinador);
    }

    // Actualizar un coordinador existente
    public Coordinador updateCoordinador(UUID id, Coordinador coordinadorDetails) {
        Coordinador coordinador = coordinadorRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordinador no encontrado"));

        coordinador.setNombre(coordinadorDetails.getNombre());
        // Actualizar otros campos necesarios

        return coordinadorRepositorio.save(coordinador);
    }

    // Eliminar un coordinador por ID
    public void deleteCoordinador(UUID id) {
        Coordinador coordinador = coordinadorRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Coordinador no encontrado"));
        coordinadorRepositorio.delete(coordinador);
    }

    // Asignar un coordinador a una carrera
    public Coordinador asignarCoordinadorACarrera(UUID coordinadorId, UUID carreraId) {
        Coordinador coordinador = coordinadorRepositorio.findById(coordinadorId)
                .orElseThrow(() -> new RuntimeException("Coordinador no encontrado"));

        Carrera carrera = carreraRepositorio.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        carrera.setCoordinador(coordinador); // Asignar el coordinador a la carrera
        carreraRepositorio.save(carrera);    // Guardar la carrera actualizada con el coordinador

        return coordinador;
    }
}
