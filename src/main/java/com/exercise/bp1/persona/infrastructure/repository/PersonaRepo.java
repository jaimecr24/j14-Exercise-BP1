package com.exercise.bp1.persona.infrastructure.repository;

import com.exercise.bp1.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaRepo extends JpaRepository<Persona,Integer> {

    List<Persona> findByUsuario(String usuario);
}
