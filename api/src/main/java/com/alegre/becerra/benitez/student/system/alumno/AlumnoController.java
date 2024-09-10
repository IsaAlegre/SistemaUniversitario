package com.alegre.becerra.benitez.student.system.alumno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/alumnos")
public class AlumnoController {

    private final AlumnoService alumnoService;

    @Autowired
    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    // Obtener todos los alumnos
    @GetMapping
    public List<Alumno> getAllAlumnos() {
        return alumnoService.getAllAlumnos();
    }

    // Obtener un alumno por DNI
    @GetMapping("/{dni}")
    public ResponseEntity<Alumno> getAlumnoByDni(@PathVariable String dni) {
        Optional<Alumno> alumno = alumnoService.getAlumnoByDni(dni);
        return alumno.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo alumno
    @PostMapping
    public Alumno createAlumno(@RequestBody Alumno alumno) {
        return alumnoService.createAlumno(alumno);
    }

    // Inscribir un alumno a una carrera
    @PostMapping("/{dni}/inscribir-carrera/{carreraId}")
    public ResponseEntity<Alumno> inscribirACarrera(@PathVariable String dni, @PathVariable UUID carreraId) {
        Alumno alumno = alumnoService.inscribirACarrera(dni, carreraId);
        return ResponseEntity.ok(alumno);
    }

    // Inscribir un alumno a una materia
    @PostMapping("/{dni}/inscribir-materia/{materiaId}")
    public ResponseEntity<Alumno> inscribirAMateria(@PathVariable String dni, @PathVariable UUID materiaId) {
        Alumno alumno = alumnoService.inscribirAMateria(dni, materiaId);
        return ResponseEntity.ok(alumno);
    }

    // Dar de baja a un alumno de una materia
    @DeleteMapping("/{dni}/baja-materia/{materiaId}")
    public ResponseEntity<Alumno> bajaDeMateria(@PathVariable String dni, @PathVariable UUID materiaId) {
        Alumno alumno = alumnoService.bajaDeMateria(dni, materiaId);
        return ResponseEntity.ok(alumno);
    }

    // Dar de baja a un alumno de una carrera (baja de todas las materias también)
    @DeleteMapping("/{dni}/baja-carrera")
    public ResponseEntity<Alumno> bajaDeCarrera(@PathVariable String dni) {
        Alumno alumno = alumnoService.bajaDeCarrera(dni);
        return ResponseEntity.ok(alumno);
    }

    // Obtener todas las relaciones del alumno
    @GetMapping("/{dni}/relaciones")
    public ResponseEntity<AlumnoDTO> getAlumnoConRelaciones(@PathVariable String dni) {
        AlumnoDTO alumnoDTO = alumnoService.getAlumnoConRelaciones(dni);
        return ResponseEntity.ok(alumnoDTO);
    }

    // Obtener todos los alumnos con todas sus relaciones
    @GetMapping("/relaciones")
    public ResponseEntity<List<AlumnoDTO>> getAllAlumnosConRelaciones() {
        List<AlumnoDTO> alumnosConRelaciones = alumnoService.getAllAlumnosConRelaciones();
        return ResponseEntity.ok(alumnosConRelaciones);
    }
}
