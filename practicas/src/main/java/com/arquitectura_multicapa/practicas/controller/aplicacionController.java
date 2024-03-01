package com.arquitectura_multicapa.practicas.controller;


import com.arquitectura_multicapa.practicas.entity.Jugadores;
import com.arquitectura_multicapa.practicas.entity.Persona;
import com.arquitectura_multicapa.practicas.repository.IPersonaRepository;
import com.arquitectura_multicapa.practicas.repository.IPromedioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class aplicacionController {

    //añadimos Inyeccion de Dependecias.
    @Autowired
    IPersonaRepository personaRepository;

    @GetMapping("/personas")
    public List<Persona> traerPersonas(){
        return personaRepository.traerPersonas();
    }
    @Autowired
    IPromedioRepository promedioRepository;
    @GetMapping("/notas")
    public float promedio(@RequestParam float nota1,
                          @RequestParam float nota2,
                          @RequestParam float nota3){

        return promedioRepository.promedio(nota1,nota2,nota3);

    }

    //Endpoint que recibe 5 jugadores y calcula la estatura promedio de estos
    @PostMapping("/jugadores")
    public String calcularPromedioEstatura(@RequestBody List<Jugadores> listaJugadores){

        float suma_estatura = 0;
        float promedio_estatura = 0;

       //guardamos los datos dentro de una lista logica, para cumplir con lo que pide el post
        List<Jugadores> lista = new ArrayList<>();
        lista = listaJugadores;

        //Sumamos las estaturas
        for (Jugadores jug : lista){
            suma_estatura = suma_estatura + jug.getEstatura();
        }
        promedio_estatura = suma_estatura / (lista.size());

        return "La estatura promedio de los jugadores ingresados es + " + promedio_estatura;
    }

}
