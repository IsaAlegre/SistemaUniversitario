package com.alegre.becerra.benitez.student.system.estado.actual;

import com.alegre.becerra.benitez.student.system.alumno.Alumno;
import com.alegre.becerra.benitez.student.system.materia.Materia;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "estado_actual")
public class EstadoActual {

    @Id
    @GeneratedValue
    private UUID uuid = UUID.randomUUID();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "alumno_dni")
    private Alumno alumno;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "materia_id")
    private Materia materia;

    private String estado;

    private int inasistencias;

    public EstadoActual() {
    }

    public EstadoActual(Alumno alumno, Materia materia, String estado, int inasistencias) {
        this.alumno = alumno;
        this.materia = materia;
        this.estado = estado;
        this.inasistencias = inasistencias;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getInasistencias() {
        return inasistencias;
    }

    public void setInasistencias(int inasistencias) {
        this.inasistencias = inasistencias;
    }
}
