package com.alegre.becerra.benitez.student.system.alumno;

import com.alegre.becerra.benitez.student.system.carrera.Carrera;
import com.alegre.becerra.benitez.student.system.carrera.CarreraRepositorio;
import com.alegre.becerra.benitez.student.system.estado.actual.EstadoActual;
import com.alegre.becerra.benitez.student.system.estado.actual.EstadoActualRepositorio;
import com.alegre.becerra.benitez.student.system.materia.Materia;
import com.alegre.becerra.benitez.student.system.materia.MateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class AlumnoService {

    private final AlumnoRepositorio alumnoRepositorio;
    private final CarreraRepositorio carreraRepositorio;
    private final MateriaRepositorio materiaRepositorio;
    private final EstadoActualRepositorio estadoActualRepositorio;

    @Autowired
    public AlumnoService(AlumnoRepositorio alumnoRepositorio, CarreraRepositorio carreraRepositorio,
                         MateriaRepositorio materiaRepositorio, EstadoActualRepositorio estadoActualRepositorio) {
        this.alumnoRepositorio = alumnoRepositorio;
        this.carreraRepositorio = carreraRepositorio;
        this.materiaRepositorio = materiaRepositorio;
        this.estadoActualRepositorio = estadoActualRepositorio;
    }

    // Obtener todos los alumnos
    public List<Alumno> getAllAlumnos() {
        return alumnoRepositorio.findAll();
    }

    // Obtener un alumno por DNI
    public Optional<Alumno> getAlumnoByDni(String dni) {
        return alumnoRepositorio.findById(dni);
    }

    // Crear un nuevo alumno
    public Alumno createAlumno(Alumno alumno) {
        return alumnoRepositorio.save(alumno);
    }

    // Inscribir alumno a una carrera
    public Alumno inscribirACarrera(String dni, UUID carreraId) {
        Alumno alumno = alumnoRepositorio.findById(dni)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        Carrera carrera = carreraRepositorio.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        alumno.setCarrera(carrera);
        return alumnoRepositorio.save(alumno);
    }

    // Inscribir alumno a una materia
    public Alumno inscribirAMateria(String dni, UUID materiaId) {
        Alumno alumno = alumnoRepositorio.findById(dni)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        Materia materia = materiaRepositorio.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        if (!alumno.getCarrera().getMaterias().contains(materia)) {
            throw new RuntimeException("El alumno no está inscrito en la carrera que ofrece esta materia");
        }

        EstadoActual estadoActual = new EstadoActual();
        estadoActual.setAlumno(alumno);
        estadoActual.setMateria(materia);
        estadoActual.setEstado("Inscripto");

        estadoActualRepositorio.save(estadoActual);
        alumno.getEstados().add(estadoActual);
        return alumnoRepositorio.save(alumno);
    }

    // Darse de baja de una materia
    public Alumno bajaDeMateria(String dni, UUID materiaId) {
        Alumno alumno = alumnoRepositorio.findById(dni)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));
        Materia materia = materiaRepositorio.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        alumno.getEstados().removeIf(estado -> estado.getMateria().equals(materia));
        return alumnoRepositorio.save(alumno);
    }

    // Darse de baja de una carrera (se da de baja de todas las materias primero)
    public Alumno bajaDeCarrera(String dni) {
        Alumno alumno = alumnoRepositorio.findById(dni)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        alumno.getEstados().clear();  // Remover todas las materias antes de darse de baja
        alumno.setCarrera(null);

        return alumnoRepositorio.save(alumno);
    }

    // Obtener todas las relaciones del alumno
    public AlumnoDTO getAlumnoConRelaciones(String dni) {
        Alumno alumno = alumnoRepositorio.findById(dni)
                .orElseThrow(() -> new RuntimeException("Alumno no encontrado"));

        // Mapea los datos del alumno a un DTO (ver DTO más abajo)
        AlumnoDTO alumnoDTO = new AlumnoDTO();
        alumnoDTO.setDni(alumno.getDni());
        alumnoDTO.setNombre(alumno.getNombre());
        alumnoDTO.setApellido(alumno.getApellido());
        alumnoDTO.setCarrera(alumno.getCarrera());
        alumnoDTO.setEstados(alumno.getEstados());

        return alumnoDTO;
    }

    public List<AlumnoDTO> getAllAlumnosConRelaciones() {
        List<Alumno> alumnos = alumnoRepositorio.findAll();

        // Convertimos la lista de Alumno a una lista de AlumnoDTO con sus relaciones
        return alumnos.stream().map(alumno -> {
            AlumnoDTO alumnoDTO = new AlumnoDTO();
            alumnoDTO.setDni(alumno.getDni());
            alumnoDTO.setNombre(alumno.getNombre());
            alumnoDTO.setApellido(alumno.getApellido());
            alumnoDTO.setCarrera(alumno.getCarrera());
            alumnoDTO.setEstados(alumno.getEstados());
            return alumnoDTO;
        }).collect(Collectors.toList());
    }
}
