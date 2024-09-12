package com.alegre.becerra.benitez.student.system.carrera;

import com.alegre.becerra.benitez.student.system.DTO.CarreraDTO;
import com.alegre.becerra.benitez.student.system.materia.Materia;
import com.alegre.becerra.benitez.student.system.materia.MateriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CarreraService {

    private final CarreraRepositorio carreraRepositorio;
    private final MateriaRepositorio materiaRepositorio;

    @Autowired
    public CarreraService(CarreraRepositorio carreraRepositorio, MateriaRepositorio materiaRepositorio) {
        this.carreraRepositorio = carreraRepositorio;
        this.materiaRepositorio = materiaRepositorio;
    }

    //Mapeo
    private CarreraDTO convertToDTO(Carrera carrera) {
        CarreraDTO dto = new CarreraDTO();
        dto.setUuid(carrera.getUuid());
        dto.setNombre(carrera.getNombre());
        dto.setDuracion(carrera.getDuracion());
        if (carrera.getCoordinador() != null) {
            dto.setCoordinadorNombre(carrera.getCoordinador().getNombre());
        }
        return dto;
    }


    // Obtener todas las carreras
    public List<CarreraDTO> getAllCarreras() {
        return carreraRepositorio.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // Obtener una carrera por ID
    public Optional<Carrera> getCarreraById(UUID id) {
        return carreraRepositorio.findById(id);
    }

    // Crear una nueva carrera
    public Carrera createCarrera(Carrera carrera) {
        return carreraRepositorio.save(carrera);
    }

    // Actualizar una carrera existente
    public Carrera updateCarrera(UUID id, Carrera carreraDetails) {
        Carrera carrera = carreraRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        carrera.setNombre(carreraDetails.getNombre());
        carrera.setDuracion(carreraDetails.getDuracion());
        carrera.setPrecioInscripcion(carreraDetails.getPrecioInscripcion());
        carrera.setPrecioCuota(carreraDetails.getPrecioCuota());

        return carreraRepositorio.save(carrera);
    }

    // Eliminar una carrera
    public void deleteCarrera(UUID id) {
        Carrera carrera = carreraRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));
        carreraRepositorio.delete(carrera);
    }

    // Asignar materias a una carrera
    public Carrera asignarMateriasACarrera(UUID carreraId, List<UUID> materiasIds) {
        Carrera carrera = carreraRepositorio.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        List<Materia> materias = materiaRepositorio.findAllById(materiasIds);
        carrera.setMaterias(materias); // Relacionar materias con la carrera
        return carreraRepositorio.save(carrera);
    }

    // Eliminar relación entre una carrera y una materia
    public Carrera eliminarMateriaDeCarrera(UUID carreraId, UUID materiaId) {
        Carrera carrera = carreraRepositorio.findById(carreraId)
                .orElseThrow(() -> new RuntimeException("Carrera no encontrada"));

        Materia materia = materiaRepositorio.findById(materiaId)
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        carrera.getMaterias().remove(materia); // Eliminar materia de la lista
        return carreraRepositorio.save(carrera);
    }
}
