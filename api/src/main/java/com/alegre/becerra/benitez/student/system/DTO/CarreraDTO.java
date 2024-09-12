package com.alegre.becerra.benitez.student.system.DTO;

import java.util.List;
import java.util.UUID;

public class CarreraDTO {
    private UUID uuid;
    private String nombre;
    private int duracion;
    private double precioInscripcion;
    private double precioCuota;
    private String coordinadorNombre;
    private List<AlumnoDTO> alumnos;
    private List<MateriaDTO> materias;

    // Getters y Setters

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public double getPrecioInscripcion() {
        return precioInscripcion;
    }

    public void setPrecioInscripcion(double precioInscripcion) {
        this.precioInscripcion = precioInscripcion;
    }

    public double getPrecioCuota() {
        return precioCuota;
    }

    public void setPrecioCuota(double precioCuota) {
        this.precioCuota = precioCuota;
    }

    public String getCoordinadorNombre() {
        return coordinadorNombre;
    }

    public void setCoordinadorNombre(String coordinadorNombre) {
        this.coordinadorNombre = coordinadorNombre;
    }

    public List<AlumnoDTO> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoDTO> alumnos) {
        this.alumnos = alumnos;
    }

    public List<MateriaDTO> getMaterias() {
        return materias;
    }

    public void setMaterias(List<MateriaDTO> materias) {
        this.materias = materias;
    }
}
