package com.pruebaHibernate.CRUD.serice;

import com.pruebaHibernate.CRUD.entity.Pet;

import java.util.List;

public interface IPetService {
    //Método para traer una lista de mascotas
    public List<Pet> getPets();
    //Método para guardar una mascota
    public void savePet(Pet pet);
    //Método para borrar una mascota
    public void deletePet(Long id);
    //Método para buscar una mascota
    public Pet findPet(Long id);
    //Método para editar una mascota
    public void editPet(Long id, String name, String race);
}
