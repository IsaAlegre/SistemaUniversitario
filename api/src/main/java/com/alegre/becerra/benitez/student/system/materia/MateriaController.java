package com.alegre.becerra.benitez.student.system.materia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/materias")
public class MateriaController {

    private final MateriaService materiaService;

    @Autowired
    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    // Obtener todas las materias
    @GetMapping
    public List<Materia> getAllMaterias() {
        return materiaService.getAllMaterias();
    }

    // Obtener una materia por ID
    @GetMapping("/{id}")
    public ResponseEntity<Materia> getMateriaById(@PathVariable UUID id) {
        Optional<Materia> materia = materiaService.getMateriaById(id);
        return materia.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva materia
    @PostMapping
    public Materia createMateria(@RequestBody Materia materia) {
        return materiaService.createMateria(materia);
    }

    // Actualizar una materia existente
    @PutMapping("/{id}")
    public ResponseEntity<Materia> updateMateria(@PathVariable UUID id, @RequestBody Materia materia) {
        return ResponseEntity.ok(materiaService.updateMateria(id, materia));
    }

    // Eliminar una materia
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMateria(@PathVariable UUID id) {
        materiaService.deleteMateria(id);
        return ResponseEntity.noContent().build();
    }

    // Asignar un profesor a una materia
    @PostMapping("/{materiaId}/profesor/{profesorId}")
    public ResponseEntity<Materia> asignarProfesor(@PathVariable UUID materiaId, @PathVariable String profesorId) {
        Materia materia = materiaService.asignarProfesor(materiaId, profesorId);
        return ResponseEntity.ok(materia);
    }

    // Quitar el profesor de una materia
    @DeleteMapping("/{materiaId}/profesor")
    public ResponseEntity<Materia> quitarProfesor(@PathVariable UUID materiaId) {
        Materia materia = materiaService.quitarProfesor(materiaId);
        return ResponseEntity.ok(materia);
    }

    // Asignar un profesor a múltiples materias
    @PostMapping("/profesor/{profesorId}/asignarMaterias")
    public ResponseEntity<List<Materia>> asignarProfesorAMaterias(@PathVariable String profesorId, @RequestBody List<UUID> materiasIds) {
        List<Materia> materias = materiaService.asignarProfesorAMaterias(profesorId, materiasIds);
        return ResponseEntity.ok(materias);
    }
}
