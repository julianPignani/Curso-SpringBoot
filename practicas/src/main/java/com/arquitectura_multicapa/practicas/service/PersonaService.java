package com.arquitectura_multicapa.practicas.service;

import com.arquitectura_multicapa.practicas.entity.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {


    @Override
    public void crearPersona(Persona per) {

    }

    @Override
    public List<Persona> traerPersonas() {
        return null;
    }

}
