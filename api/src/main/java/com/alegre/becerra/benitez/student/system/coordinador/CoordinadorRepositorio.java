package com.alegre.becerra.benitez.student.system.coordinador;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CoordinadorRepositorio extends JpaRepository<Coordinador, UUID> {
}
