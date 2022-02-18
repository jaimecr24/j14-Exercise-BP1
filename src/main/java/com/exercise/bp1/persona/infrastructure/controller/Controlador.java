package com.exercise.bp1.persona.infrastructure.controller;

import com.exercise.bp1.persona.application.port.IPersona;
import com.exercise.bp1.persona.infrastructure.controller.dto.PersonaInputDTO;
import com.exercise.bp1.persona.infrastructure.controller.dto.PersonaOutputDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controlador {

    @Autowired
    IPersona personaService;

    @GetMapping
    public List<PersonaOutputDTO> findAll()
    {
        return personaService.findAll();
    }

    @GetMapping("{id}")
    public PersonaOutputDTO getById(@PathVariable Integer id) throws Exception
    {
        return personaService.getById(id);
    }

    @GetMapping("/{usuario}/usuario")
    public List<PersonaOutputDTO> getByUser(@PathVariable String usuario) throws Exception
    {
        return personaService.getByUser(usuario);
    }

    @PostMapping
    public PersonaOutputDTO add(@RequestBody PersonaInputDTO personaInputDTO) throws Exception
    {
        return personaService.addPersona(personaInputDTO);
    }

    @PutMapping("{id}")
    public PersonaOutputDTO put(@RequestBody PersonaInputDTO personaInputDTO, @PathVariable Integer id) throws Exception
    {
        return personaService.putPersona(id, personaInputDTO);
    }

    @DeleteMapping("{id}")
    public PersonaOutputDTO delById(@PathVariable Integer id) throws Exception
    {
        return personaService.delPersona(id);
    }

}
