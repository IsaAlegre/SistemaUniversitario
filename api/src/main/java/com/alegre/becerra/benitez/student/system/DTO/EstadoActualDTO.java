package com.alegre.becerra.benitez.student.system.DTO;

import java.util.UUID;

public class EstadoActualDTO {

    private UUID id;
    private String estado;
    private Integer inasistencias;

    public EstadoActualDTO(UUID id, String estado, Integer inasistencias) {
        this.id = id;
        this.estado = estado;
        this.inasistencias = inasistencias;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getInasistencias() {
        return inasistencias;
    }

    public void setInasistencias(Integer inasistencias) {
        this.inasistencias = inasistencias;
    }
}
