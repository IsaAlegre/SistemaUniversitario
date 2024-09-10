package com.alegre.becerra.benitez.student.system.carrera;

import com.alegre.becerra.benitez.student.system.alumno.Alumno;
import com.alegre.becerra.benitez.student.system.coordinador.Coordinador;
import com.alegre.becerra.benitez.student.system.materia.Materia;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "carrera")
public class Carrera {

    @Id
    @GeneratedValue
    private UUID uuid = UUID.randomUUID();

    private String nombre;

    private int duracion; // en años

    private double precioInscripcion;

    private double precioCuota;

    @OneToMany(mappedBy = "carrera", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Alumno> alumnos = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "coordinador_id")
    private Coordinador coordinador;

    @ManyToMany(mappedBy = "carreras")
    private List<Materia> materias = new ArrayList<>();

    public Carrera() {}

    public Carrera(String nombre, int duracion, Coordinador coordinador, double precioInscripcion, double precioCuota) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.precioInscripcion = precioInscripcion;
        this.precioCuota = precioCuota;
    }

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

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public Coordinador getCoordinador() {
        return coordinador;
    }

    public void setCoordinador(Coordinador coordinador) {
        this.coordinador = coordinador;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
