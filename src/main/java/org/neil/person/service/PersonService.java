package org.neil.person.service;

import org.neil.person.PersonNotFoundException;
import org.neil.person.datasource.PersonRepository;
import org.neil.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Created by neilsharpe on 1/9/16.
 */
@Component
public class PersonService {
  private final PersonRepository personRepository;

  @Autowired
  public PersonService(PersonRepository personRepository) {
    if(personRepository == null){
      throw new NullPointerException();
    }
    this.personRepository = personRepository;
  }

  public Person save(Person p){
    return personRepository.save(p);
  }

  public Person findOne(Long id){
    Person toReturn = personRepository.findOne(id);
    if(toReturn==null){
      throw new PersonNotFoundException(id);
    }
    return toReturn;
  }

  public Stream<Person> findPersons(Collection<Long> ids){
     return StreamSupport.stream(
             personRepository.findAll(ids).spliterator(),false);
  }

  public Person updatePesron(Long id, Person person){
    Person toReturn = personRepository.findOne(id);
    if(toReturn==null){
      throw new PersonNotFoundException(id);
    }
    person.setId(id);
    personRepository.save(person);
    return toReturn;
  }

  public void delete(Long id){
    personRepository.delete(id);
  }
}
