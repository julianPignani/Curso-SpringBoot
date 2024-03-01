package com.arquitectura_multicapa.practicas.service;

import com.arquitectura_multicapa.practicas.entity.Persona;

import java.util.List;

public interface IPersonaService {

    public void crearPersona(Persona per);

    public List<Persona> traerPersonas();
}
