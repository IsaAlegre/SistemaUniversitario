package com.alegre.becerra.benitez.student.system.alumno;


import com.alegre.becerra.benitez.student.system.carrera.Carrera;
import com.alegre.becerra.benitez.student.system.estado.actual.EstadoActual;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alumno")
public class Alumno {

    @Id
    private String dni;
    private String nombre;
    private String apellido;
    private LocalDate fechaDeNacimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "carrera_id")
    private Carrera carrera;

    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstadoActual> estados = new ArrayList<>();

    public Alumno() {}

    public Alumno(String dni, String nombre, String apellido, LocalDate fechaDeNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

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

    public LocalDate getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
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
