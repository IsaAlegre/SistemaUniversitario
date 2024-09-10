package com.alegre.becerra.benitez.student.system.profesor;

import com.alegre.becerra.benitez.student.system.materia.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/profesores")
public class ProfesorController {

    private final ProfesorService profesorService;

    @Autowired
    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    // Obtener todos los profesores
    @GetMapping
    public List<Profesor> getAllProfesores() {
        return profesorService.getAllProfesores();
    }

    // Obtener un profesor por DNI
    @GetMapping("/{dni}")
    public ResponseEntity<Profesor> getProfesorByDni(@PathVariable String dni) {
        Optional<Profesor> profesor = profesorService.getProfesorByDni(dni);
        return profesor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo profesor
    @PostMapping
    public Profesor createProfesor(@RequestBody Profesor profesor) {
        return profesorService.createProfesor(profesor);
    }

    // Actualizar un profesor existente
    @PutMapping("/{dni}")
    public ResponseEntity<Profesor> updateProfesor(@PathVariable String dni, @RequestBody Profesor profesorDetails) {
        Profesor updatedProfesor = profesorService.updateProfesor(dni, profesorDetails);
        return ResponseEntity.ok(updatedProfesor);
    }

    // Eliminar un profesor
    @DeleteMapping("/{dni}")
    public ResponseEntity<Void> deleteProfesor(@PathVariable String dni) {
        profesorService.deleteProfesor(dni);
        return ResponseEntity.noContent().build();
    }

    // Obtener materias de un profesor
    @GetMapping("/{dni}/materias")
    public ResponseEntity<List<Materia>> getMateriasByProfesor(@PathVariable String dni) {
        List<Materia> materias = profesorService.getMateriasByProfesor(dni);
        return ResponseEntity.ok(materias);
    }

    // Desasignar todas las materias de un profesor
    @DeleteMapping("/{dni}/materias")
    public ResponseEntity<Profesor> desasignarMaterias(@PathVariable String dni) {
        Profesor profesor = profesorService.desasignarMaterias(dni);
        return ResponseEntity.ok(profesor);
    }
}
