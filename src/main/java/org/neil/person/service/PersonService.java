package org.neil.person.service;

import org.neil.person.PersonNotFoundException;
import org.neil.person.datasource.PersonRepository;
import org.neil.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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

  public Stream<Person> save(Stream<Person> p){
     return save(p.collect(Collectors.toList()));
  }

  public Stream<Person> save(Collection<Person> persons){
    return StreamSupport.stream(
            personRepository.save(persons).spliterator(),false);
  }

  public Person findOne(Long id){
    Person toReturn = personRepository.findOne(id);
    if(toReturn==null){
      throw new PersonNotFoundException(id);
    }
    return toReturn;
  }

  public Stream<Person> findAll(){
    return StreamSupport.stream(
            personRepository.findAll().spliterator(),false);
  }

  public Stream<Person> findPersons(Collection<Long> ids){
     return StreamSupport.stream(
             personRepository.findAll(ids).spliterator(),false);
  }

  public Person updatePerson(Long id, Person person){
    Person previousState = personRepository.findOne(id);
    if(previousState==null){
      throw new PersonNotFoundException(id);
    }

    Optional.ofNullable(person.getFirstName())
            .ifPresent(x -> previousState.setFirstName(x) );
    Optional.ofNullable( person.getBirthDate() )
            .ifPresent(x -> previousState.setBirthDate(x));
    Optional.ofNullable( person.getGender() )
            .ifPresent( x -> previousState.setGender(x) );
    Optional.ofNullable( person.getHeight() )
            .ifPresent( x -> previousState.setHeight(x) );
    Optional.ofNullable( person.getWeightInPounds() )
            .ifPresent( x -> previousState.setWeightInPounds(x) );

    personRepository.save(previousState);
    return previousState;
  }

  public void delete(Long id){
    personRepository.delete(id);
  }

  public Stream<Person> isAnAdultFilter(Stream<Person> input, Boolean isAnAdult){
    /**
     * isAnAdultPredicate.Test(Person) returns true if the person is an adult
     */
    Predicate<Person> isAnAdultPredicate = Person.isAnAdult();

    /**
     * if filtering to find all non adults negate the predicate.
     */
    if(!isAnAdult){
      isAnAdultPredicate = isAnAdultPredicate.negate();
    }
    return input.filter(isAnAdultPredicate);
  }

  public Stream<Person> findAllFilteredByAdults(Boolean isAnAdult){
    return isAnAdultFilter(findAll(),isAnAdult);
  }
}
