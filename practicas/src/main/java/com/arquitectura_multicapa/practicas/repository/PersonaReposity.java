package com.arquitectura_multicapa.practicas.repository;

import com.arquitectura_multicapa.practicas.entity.Persona;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaReposity implements IPersonaRepository, IPromedioRepository {
    public List<Persona> traerPersonas(){

        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1L,"Julian","Pignani"));
        personas.add(new Persona(2L,"Lucia","Eandi"));
        personas.add(new Persona(3L,"Miguel", "Pignani"));

        return personas;
    }

    @Override
    public float promedio(float n1, float n2, float n3) {
        float promedio = (n1 + n2 + n3) / 3;

        return promedio;
    }


}
