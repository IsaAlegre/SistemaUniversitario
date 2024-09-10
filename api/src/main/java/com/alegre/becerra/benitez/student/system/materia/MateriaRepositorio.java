package com.alegre.becerra.benitez.student.system.materia;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MateriaRepositorio extends JpaRepository<Materia, UUID> {
}
