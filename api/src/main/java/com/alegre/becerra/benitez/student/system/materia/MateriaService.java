package com.alegre.becerra.benitez.student.system.materia;

import com.alegre.becerra.benitez.student.system.profesor.Profesor;
import com.alegre.becerra.benitez.student.system.profesor.ProfesorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MateriaService {

    private final MateriaRepositorio materiaRepositorio;
    private final ProfesorRepositorio profesorRepositorio;

    @Autowired
    public MateriaService(MateriaRepositorio materiaRepositorio, ProfesorRepositorio profesorRepositorio) {
        this.materiaRepositorio = materiaRepositorio;
        this.profesorRepositorio = profesorRepositorio;
    }

    // Obtener todas las materias
    public List<Materia> getAllMaterias() {
        return materiaRepositorio.findAll();
    }

    // Obtener una materia por ID
    public Optional<Materia> getMateriaById(UUID id) {
        return materiaRepositorio.findById(id);
    }

    // Crear una nueva materia
    public Materia createMateria(Materia materia) {
        return materiaRepositorio.save(materia);
    }

    // Actualizar una materia existente
    public Materia updateMateria(UUID id, Materia materiaDetails) {
        Materia materia = materiaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        materia.setNombre(materiaDetails.getNombre());
        materia.setCurso(materiaDetails.getCurso());
        materia.setCuatrimestre(materiaDetails.getCuatrimestre());
        return materiaRepositorio.save(materia);
    }

    // Eliminar una materia
    public void deleteMateria(UUID id) {
        Materia materia = materiaRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));
        materiaRepositorio.delete(materia);
    }

    // Relacionar una materia con un profesor
    public Materia asignarProfesor(UUID materiaId, String profesorId) {
        Materia materia = materiaRepositorio.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        Profesor profesor = profesorRepositorio.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        materia.setProfesor(profesor); // Relacionar profesor con materia
        return materiaRepositorio.save(materia);
    }

    // Quitar la relación de un profesor con una materia
    public Materia quitarProfesor(UUID materiaId) {
        Materia materia = materiaRepositorio.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        materia.setProfesor(null); // Quitar profesor de la materia
        return materiaRepositorio.save(materia);
    }

    // Asignar un profesor a múltiples materias
    public List<Materia> asignarProfesorAMaterias(String profesorId, List<UUID> materiasIds) {
        Profesor profesor = profesorRepositorio.findById(profesorId)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        List<Materia> materias = materiaRepositorio.findAllById(materiasIds);
        for (Materia materia : materias) {
            materia.setProfesor(profesor);
        }
        return materiaRepositorio.saveAll(materias);
    }
}
