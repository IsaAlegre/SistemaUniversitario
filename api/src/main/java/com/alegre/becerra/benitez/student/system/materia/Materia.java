package com.alegre.becerra.benitez.student.system.materia;


import com.alegre.becerra.benitez.student.system.carrera.Carrera;
import com.alegre.becerra.benitez.student.system.estado.actual.EstadoActual;
import com.alegre.becerra.benitez.student.system.profesor.Profesor;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "materia")
public class Materia {

    @Id
    @GeneratedValue
    private UUID uuid = UUID.randomUUID();
    private String nombre;
    private int curso;
    private String cuatrimestre;

    @OneToMany(mappedBy = "materia", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EstadoActual> estados = new ArrayList<>();

    @ManyToOne
    private Profesor profesor;

    @ManyToMany
    @JoinTable(
            name = "materia_carrera",
            joinColumns = @JoinColumn(name = "materia_id"),
            inverseJoinColumns = @JoinColumn(name = "carrera_id")
    )
    private List<Carrera> carreras = new ArrayList<>();

    public Materia() {
    }

    public Materia(String nombre, int curso, String cuatrimestre) {
        this.nombre = nombre;
        this.curso = curso;
        this.cuatrimestre = cuatrimestre;
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

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public String getCuatrimestre() {
        return cuatrimestre;
    }

    public void setCuatrimestre(String cuatrimestre) {
        this.cuatrimestre = cuatrimestre;
    }

    public List<EstadoActual> getEstados() {
        return estados;
    }

    public void setEstados(List<EstadoActual> estados) {
        this.estados = estados;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public List<Carrera> getCarreras() {
        return carreras;
    }

    public void setCarreras(List<Carrera> carreras) {
        this.carreras = carreras;
    }
}