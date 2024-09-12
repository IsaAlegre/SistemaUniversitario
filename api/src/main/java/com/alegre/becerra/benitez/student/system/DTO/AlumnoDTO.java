package com.alegre.becerra.benitez.student.system.DTO;

import com.alegre.becerra.benitez.student.system.carrera.Carrera;
import com.alegre.becerra.benitez.student.system.estado.actual.EstadoActual;

import java.util.List;

public class AlumnoDTO {

    private String dni;
    private String nombre;
    private String apellido;
    private Carrera carrera;
    private List<EstadoActual> estados;

    // Getters y Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public List<EstadoActual> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadoActual> estados) {
        this.estados = estados;
    }
}
