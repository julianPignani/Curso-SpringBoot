package com.pruebaHibernate.CRUD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idPet;
    private String name;
    private String race;

    public Pet() {
    }

    public Pet(Long id_pet, String name, String race) {
        this.idPet = idPet;
        this.name = name;
        this.race = race;
    }
}
