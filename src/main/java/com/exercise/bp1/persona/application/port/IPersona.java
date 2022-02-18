package com.exercise.bp1.persona.application.port;

import com.exercise.bp1.persona.infrastructure.controller.dto.PersonaInputDTO;
import com.exercise.bp1.persona.infrastructure.controller.dto.PersonaOutputDTO;

import java.util.List;

public interface IPersona {
    List<PersonaOutputDTO> findAll();
    List<PersonaOutputDTO> getByUser(String usuario);
    PersonaOutputDTO getById(Integer id) throws Exception;
    PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO putPersona(Integer id, PersonaInputDTO personaInputDTO) throws Exception;
    PersonaOutputDTO delPersona(Integer id) throws Exception;
}
