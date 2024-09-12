package com.alegre.becerra.benitez.student.system.DTO;

import java.util.List;
import java.util.UUID;

public class ProfesorDTO {
    private UUID id;
    private String nombre;
    private String dni;
    private List<MateriaDTO> materias;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<MateriaDTO> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaDTO> materias) {
        this.materias = materias;
    }
}
