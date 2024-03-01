package com.pruebaHibernate.CRUD.serice;

import com.pruebaHibernate.CRUD.entity.Person;
import com.pruebaHibernate.CRUD.repository.IPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
@Service
public class PersonService implements IPersonService {
    @Autowired
    private IPersonRepository personRepository;

    @Override
    public List<Person> getPeople() {

        //Usamos nuestro objeto repository y el método JPA findAll para traer la lista
            List<Person> listPeople = personRepository.findAll();
            return listPeople;
    }

    @Override
    public void savePerson(Person person) {
        //Usamos nuestro objeto repository y el método JPA save() para guardar una persona
        personRepository.save(person);

    }

    @Override
    public void deletePerson(Long id) {
        //Usamos nuestro objeto repository y el método JPA delete para eliminar una persona de la db
        personRepository.deleteById(id);
    }

    @Override
    public Person findPerson(Long id) {
        //Usamos nuestro objeto repository y el método JPA findByid para buscar una persona
        // si no encuentra nada devuelve null
        Person person = personRepository.findById(id).orElse(null);
        return person;
    }

    @Override
    public void editPerson(Long idOriginal, String newName, String newLastname, int newAge) {
        //utilizamos this porque llamamos al mismo método findperson de esta clase.
        Person person = this.findPerson(idOriginal);
        person.setName(newName);
        person.setLastname(newLastname);
        person.setAge(newAge);

        //Volvemos a usar this para llamar al método savePersona de esta clase
        this.savePerson(person);
    }

    @Override
    public void editPerson(Person person) {
        //recibe el objeto completo y lo guarda
        this.savePerson(person);
    }


}
