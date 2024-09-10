package com.alegre.becerra.benitez.student.system.profesor;

import com.alegre.becerra.benitez.student.system.materia.Materia;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "profesor")
public class Profesor {

    @Id
    private String dni;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "profesor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Materia> materias;

    public Profesor() {}

    public Profesor(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
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

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Materia> materias) {
        this.materias = materias;
    }
}
