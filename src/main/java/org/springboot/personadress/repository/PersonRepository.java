package org.springboot.personadress.repository;

import org.springboot.personadress.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
}
