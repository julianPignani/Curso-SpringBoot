package com.pruebaHibernate.CRUD.controller;

import com.pruebaHibernate.CRUD.entity.Pet;
import com.pruebaHibernate.CRUD.serice.IPetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PetController {

    @Autowired
    private IPetService iPetService;

    @GetMapping("/pet/get")
    public List<Pet> getPets(){
        return iPetService.getPets();
    }

    @PostMapping("/pet/create")
    public String createPet(@RequestBody Pet pet){
        iPetService.savePet(pet);
        return "La mascota se creo correctamente";
    }
}
