package com.alegre.becerra.benitez.student.system.DTO;

import java.util.UUID;

public class MateriaDTO {

    private UUID id;
    private String nombre;
    private String profesorNombre;

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

    public String getProfesorNombre() {
        return profesorNombre;
    }

    public void setProfesorNombre(String profesorNombre) {
        this.profesorNombre = profesorNombre;
    }
}
