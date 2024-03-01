package com.pruebaHibernate.CRUD.serice;

import com.pruebaHibernate.CRUD.entity.Pet;
import com.pruebaHibernate.CRUD.repository.IPetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PetService implements IPetService {

    @Autowired
    private IPetRepository iPetRepository;
    @Override
    public List<Pet> getPets() {
        List<Pet> pets = iPetRepository.findAll();
        return pets;
    }

    @Override
    public void savePet(Pet pet) {
        iPetRepository.save(pet);
    }

    @Override
    public void deletePet(Long id) {
       iPetRepository.findById(id);

    }

    @Override
    public Pet findPet(Long id) {
        Pet pet = iPetRepository.findById(id).orElse(null);
        return pet;
    }

    @Override
    public void editPet(Long id, String name, String race) {
        //buscamos la mascota
        Pet pet = this.findPet(id);
        //seteamos los valores
        pet.setName(name);
        pet.setRace(race);

        //guardamos las modificaciones
        this.savePet(pet);

    }
}
