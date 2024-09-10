package com.alegre.becerra.benitez.student.system.profesor;

import com.alegre.becerra.benitez.student.system.materia.Materia;
import com.alegre.becerra.benitez.student.system.materia.MateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesorService {

    private final ProfesorRepositorio profesorRepositorio;
    private final MateriaRepositorio materiaRepositorio;

    @Autowired
    public ProfesorService(ProfesorRepositorio profesorRepositorio, MateriaRepositorio materiaRepositorio) {
        this.profesorRepositorio = profesorRepositorio;
        this.materiaRepositorio = materiaRepositorio;
    }

    // Obtener todos los profesores
    public List<Profesor> getAllProfesores() {
        return profesorRepositorio.findAll();
    }

    // Obtener un profesor por DNI
    public Optional<Profesor> getProfesorByDni(String dni) {
        return profesorRepositorio.findById(dni);
    }

    // Crear un nuevo profesor
    public Profesor createProfesor(Profesor profesor) {
        return profesorRepositorio.save(profesor);
    }

    // Actualizar un profesor existente
    public Profesor updateProfesor(String dni, Profesor profesorDetails) {
        Profesor profesor = profesorRepositorio.findById(dni)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        profesor.setNombre(profesorDetails.getNombre());
        profesor.setApellido(profesorDetails.getApellido());

        return profesorRepositorio.save(profesor);
    }

    // Eliminar un profesor
    public void deleteProfesor(String dni) {
        Profesor profesor = profesorRepositorio.findById(dni)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));
        profesorRepositorio.delete(profesor);
    }

    // Obtener materias asociadas a un profesor
    public List<Materia> getMateriasByProfesor(String dni) {
        Profesor profesor = profesorRepositorio.findById(dni)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        return profesor.getMaterias();
    }

    // Desasignar todas las materias de un profesor
    public Profesor desasignarMaterias(String dni) {
        Profesor profesor = profesorRepositorio.findById(dni)
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        for (Materia materia : profesor.getMaterias()) {
            materia.setProfesor(null);
            materiaRepositorio.save(materia);
        }

        profesor.getMaterias().clear();
        return profesorRepositorio.save(profesor);
    }
}
