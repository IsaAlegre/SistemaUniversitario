package com.alegre.becerra.benitez.student.system.carrera;

import com.alegre.becerra.benitez.student.system.materia.Materia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/carreras")
public class CarreraController {

    private final CarreraService carreraService;

    @Autowired
    public CarreraController(CarreraService carreraService) {
        this.carreraService = carreraService;
    }

    // Obtener todas las carreras
    @GetMapping
    public List<Carrera> getAllCarreras() {
        return carreraService.getAllCarreras();
    }

    // Obtener una carrera por ID
    @GetMapping("/{id}")
    public ResponseEntity<Carrera> getCarreraById(@PathVariable UUID id) {
        Optional<Carrera> carrera = carreraService.getCarreraById(id);
        return carrera.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva carrera
    @PostMapping
    public Carrera createCarrera(@RequestBody Carrera carrera) {
        return carreraService.createCarrera(carrera);
    }

    // Actualizar una carrera existente
    @PutMapping("/{id}")
    public ResponseEntity<Carrera> updateCarrera(@PathVariable UUID id, @RequestBody Carrera carrera) {
        return ResponseEntity.ok(carreraService.updateCarrera(id, carrera));
    }

    // Eliminar una carrera por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCarrera(@PathVariable UUID id) {
        carreraService.deleteCarrera(id);
        return ResponseEntity.noContent().build();
    }

    // Asignar materias a una carrera
    @PostMapping("/{carreraId}/materias")
    public ResponseEntity<Carrera> asignarMateriasACarrera(@PathVariable UUID carreraId, @RequestBody List<UUID> materiasIds) {
        Carrera carrera = carreraService.asignarMateriasACarrera(carreraId, materiasIds);
        return ResponseEntity.ok(carrera);
    }

    // Eliminar una materia de una carrera
    @DeleteMapping("/{carreraId}/materias/{materiaId}")
    public ResponseEntity<Carrera> eliminarMateriaDeCarrera(@PathVariable UUID carreraId, @PathVariable UUID materiaId) {
        Carrera carrera = carreraService.eliminarMateriaDeCarrera(carreraId, materiaId);
        return ResponseEntity.ok(carrera);
    }
}
