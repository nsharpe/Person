package org.neil.person.controller;

import org.neil.person.datasource.PersonRepository;
import org.neil.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by neilsharpe on 1/1/16.
 */
@RestController()
@RequestMapping(value="/person",consumes="application/json")
public class PersonController {

  private PersonRepository personRepository;

  @Autowired
  public PersonController(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  @RequestMapping(value="/", method = RequestMethod.GET)
  public String index() {
    return "Welcome to the Person Service";
  }

  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public Person getPerson(@PathVariable UUID id){
    return personRepository.findOne(id);
  }

  @RequestMapping( method = RequestMethod.POST)
  public Person createPerson(@RequestBody Person p){
    return personRepository.save(p);
  }

  @RequestMapping(value="/{id}",method = RequestMethod.PUT)
  public Person updatePerson(@RequestBody Person p, @PathVariable UUID id){
    return personRepository.save(p);
  }

  @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
  public void deletePerson(@PathVariable UUID id){
    personRepository.delete(id);
  }
}
