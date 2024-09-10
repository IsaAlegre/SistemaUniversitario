package com.alegre.becerra.benitez.student.system.estado.actual;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface EstadoActualRepositorio extends JpaRepository<EstadoActual, UUID> {
}
