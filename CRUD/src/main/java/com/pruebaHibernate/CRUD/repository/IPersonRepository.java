package com.pruebaHibernate.CRUD.repository;

import com.pruebaHibernate.CRUD.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//La interface extiende de JpaRepository (que maneja repositorios JPA)
//En los parámetros <> debe ir: <clase a persistir, tipo de dato de su ID>
public interface IPersonRepository extends JpaRepository<Person,Long> {
}
