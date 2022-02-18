package com.exercise.bp1.persona.application;

import com.exercise.bp1.persona.application.port.IPersona;
import com.exercise.bp1.persona.domain.Persona;
import com.exercise.bp1.persona.infrastructure.controller.dto.PersonaInputDTO;
import com.exercise.bp1.persona.infrastructure.controller.dto.PersonaOutputDTO;
import com.exercise.bp1.persona.infrastructure.repository.PersonaRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonaService implements IPersona {

    private final PersonaRepo personaRepo;

    public PersonaService(PersonaRepo personaRepo){
        super();
        this.personaRepo = personaRepo;
    }

    @Override
    public List<PersonaOutputDTO> findAll() {
        List<Persona> listaPersona = personaRepo.findAll();
        List<PersonaOutputDTO> listaPersonaDTO = new ArrayList<>();
        for (Persona persona:listaPersona) listaPersonaDTO.add(new PersonaOutputDTO(persona));
        return listaPersonaDTO;
    }

    @Override
    public List<PersonaOutputDTO> getByUser(String usuario) {
        List<Persona> listaPersona = personaRepo.findByUsuario(usuario);
        List<PersonaOutputDTO> listaPersonaDTO = new ArrayList<>();
        for (Persona persona:listaPersona) listaPersonaDTO.add(new PersonaOutputDTO(persona));
        return listaPersonaDTO;
    }

    @Override
    public PersonaOutputDTO getById(Integer id) throws Exception{
        Persona persona = personaRepo.findById(id).orElseThrow(()->new Exception("id "+id+" not found."));
        return new PersonaOutputDTO(persona);
    }

    @Override
    public PersonaOutputDTO addPersona(PersonaInputDTO personaInputDTO) throws Exception {
        this.validar(personaInputDTO);
        Persona persona = personaInputDTO.toPersona();
        personaRepo.save(persona);
        return new PersonaOutputDTO(persona);
    }

    @Override
    public PersonaOutputDTO putPersona(Integer id, PersonaInputDTO personaInputDTO) throws Exception{
        this.validar(personaInputDTO);
        Persona persona = personaRepo.findById(id).orElseThrow(()->new Exception("id "+id+" not found."));
        persona.setPassword(personaInputDTO.getPassword());
        persona.setUsuario(personaInputDTO.getUsuario());
        persona.setName(personaInputDTO.getName());
        persona.setUsuario(personaInputDTO.getUsuario());
        persona.setName(personaInputDTO.getName());
        persona.setSurname(personaInputDTO.getSurname());
        persona.setCompany_email(personaInputDTO.getCompany_email());
        persona.setPersonal_email(personaInputDTO.getPersonal_email());
        persona.setCity(personaInputDTO.getCity());
        persona.setActive(personaInputDTO.getActive());
        persona.setCreated_date(personaInputDTO.getCreated_date());
        persona.setImagen_url(personaInputDTO.getImagen_url());
        persona.setTermination_date(personaInputDTO.getTermination_date());
        personaRepo.save(persona);
        return new PersonaOutputDTO(persona);
    }

    @Override
    public PersonaOutputDTO delPersona(Integer id) throws Exception{
        Persona persona = personaRepo.findById(id).orElseThrow(()->new Exception("id "+id+" not found."));
        PersonaOutputDTO personaOutputDTO = new PersonaOutputDTO(persona);
        personaRepo.delete(persona);
        return personaOutputDTO;
    }

    private void validar(PersonaInputDTO personaInputDTO) throws Exception{
        String usuario = personaInputDTO.getUsuario();
        if (usuario==null) throw new Exception("Error: user is null.");
        if (usuario.length()<6 || usuario.length()>10) throw new Exception("Error: user length must be between 6 and 10 characters");
        if (personaInputDTO.getPassword()==null) throw new Exception("Error: password is null.");
        if (personaInputDTO.getName()==null) throw new Exception("Error: name is null.");
        if (personaInputDTO.getCompany_email()==null) throw new Exception("Error: Company_email is null.");
        if (personaInputDTO.getPersonal_email()==null) throw new Exception("Error: Personal_email is null.");
        if (personaInputDTO.getCity()==null) throw new Exception("Error: City is null.");
        if(personaInputDTO.getActive()==null) throw new Exception("Error: active is null");
        if (personaInputDTO.getCreated_date()==null) throw new Exception("Error: Created_date is null");
    }
}
