package com.pruebaHibernate.CRUD.repository;

import com.pruebaHibernate.CRUD.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPetRepository extends JpaRepository<Pet, Long> {
}
