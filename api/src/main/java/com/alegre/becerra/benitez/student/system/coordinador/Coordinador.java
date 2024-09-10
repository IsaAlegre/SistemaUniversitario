package com.alegre.becerra.benitez.student.system.coordinador;

import com.alegre.becerra.benitez.student.system.carrera.Carrera;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name= "coordinador")
public class Coordinador {
    @Id
    @GeneratedValue
    private UUID uuid = UUID.randomUUID();

    private String nombre;
    private String apellido;


    @OneToOne(mappedBy = "coordinador", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Carrera carrera;

    public Coordinador() {
    }

    public Coordinador(String nombre, String apellido, Carrera carrera) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
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
}
