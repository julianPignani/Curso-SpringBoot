package com.pruebaHibernate.CRUD.controller;

import com.pruebaHibernate.CRUD.entity.Person;
import com.pruebaHibernate.CRUD.serice.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private IPersonService iPersonService; //Hacemos la inyección en nuesta interface donde estan nuestros métodos

    //Endpoint para obtener todas las personas
    @GetMapping("/people/get")
    public List<Person> getPeople(){
        return iPersonService.getPeople();
    }

    //Endpoint para crear una persona
    @PostMapping("/person/create")
    public String createStudent(@RequestBody Person person){
        iPersonService.savePerson(person);
        //Devolvemos un msj si se creo correctamente
        return "La persona fue creada correctamente";
    }
    //Endpoint para dar de baja una persona
    @DeleteMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable Long id){
        try {
            //buscamos la persona por el id
            Person personDelete = iPersonService.findPerson(id);
            //Verificamos si la persona existe
            if(personDelete == null){
                //Devuelve 404 y un msj indicando que la persona no existe
                return "Cliente no encontrado con id: " +id;
            }
            //Elimina el cliente
            iPersonService.deletePerson(id);

            //debería devolver un 204 despues de eliminarlo(sin contenido)
            return "La persona fue eliminada correctamente";

        }catch (DataAccessException ex){
            return ex.toString();
        }

    }
    //Endpoint para modificar una persona
    //Es mala practica modificar el id existente!! (solo en forma de practica)
    @PutMapping("/person/edit/{idOriginal}")
    public Person editPerson(@PathVariable Long idOriginal,
                             @RequestParam(required = false, name = "name") String newName,
                             @RequestParam(required = false, name = "lastname") String newLastname,
                             @RequestParam(required = false, name = "age") int newAge) {
        //Envío id original (para buscar)
        //Envío nuevos datos para modificar
        iPersonService.editPerson(idOriginal,newName, newLastname , newAge);

        //busco la persona editada para mostrarla en la response
        Person person = iPersonService.findPerson(idOriginal);
        //retorna la nueva persona
        return person;
    }
    //Endpoint para modificar una persona y una mascota
    @PostMapping("/person/pet/edit")
    public Person editPerson(@RequestBody Person person){
        //llamamos al método editPerson
        iPersonService.editPerson(person);
        //retornamos una persona según el id
        return  iPersonService.findPerson(person.getId());
    }
}
