package com.alegre.becerra.benitez.student.system.carrera;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface CarreraRepositorio extends JpaRepository<Carrera, UUID>{
}
