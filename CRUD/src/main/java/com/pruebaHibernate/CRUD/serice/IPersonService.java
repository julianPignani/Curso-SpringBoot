package com.pruebaHibernate.CRUD.serice;

import com.pruebaHibernate.CRUD.entity.Person;
import java.util.List;

public interface IPersonService {
    //método para traer todas las personas
    public List<Person> getPeople();

    //método para dar de alta una persona
    public void savePerson (Person person);

    //Método para borrar una persona
    public void deletePerson(Long id);

    //Método para encontrar una persona
    public Person findPerson(Long id);

    //método para editar una persona
    public void editPerson(Long idOriginal, String newName, String newLastname,int newAge);

    public void editPerson(Person person);
}
