package uk.co.dave.person;

import org.springframework.data.repository.CrudRepository;

interface PersonRepository extends CrudRepository<Person, String> {

}