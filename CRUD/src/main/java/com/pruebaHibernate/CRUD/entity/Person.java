package com.pruebaHibernate.CRUD.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter @Setter
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String lastname;
    private int age;
    //@OneToOne //relación 1 a 1
    //@JoinColumn(name = "id_pet",referencedColumnName = "idPet") //Con esto hacemos que se relacionen las tablas.
    //ahora utilizamos la relación OneToMany
    @OneToMany
    private List<Pet> ListPets;

    public Person() {
    }

    public Person(Long id, String name, String lastname, int age, List<Pet> listPets) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        ListPets = listPets;
    }
}
