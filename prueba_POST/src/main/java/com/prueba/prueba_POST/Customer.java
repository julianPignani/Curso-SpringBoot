package com.prueba.prueba_POST;

import lombok.Getter;
import lombok.Setter;

//Agregamos las anotaciones utilizando lombook para los getter y setter.
@Getter @Setter
public class Customer {
//Nuestra clase cliente
    private Long id;
    private String name;
    private String lastname;

    public Customer(Long id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }
}
