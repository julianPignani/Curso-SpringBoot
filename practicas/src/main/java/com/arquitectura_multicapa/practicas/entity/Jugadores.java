package com.arquitectura_multicapa.practicas.entity;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Jugadores {
    private Long id;
    private String dni;
    private String nombre;
    private  String apellido;
    private int edad;
    private float peso;
    private float estatura;

    public Jugadores() {
    }

    public Jugadores(Long id, String dni, String nombre, String apellido, int edad, float peso, float estatura) {
        this.id = id;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.peso = peso;
        this.estatura = estatura;
    }
}
