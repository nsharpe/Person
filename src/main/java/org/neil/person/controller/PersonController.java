package org.neil.person.controller;

import org.neil.person.datasource.PersonRepository;
import org.neil.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Created by neilsharpe on 1/1/16.
 */
@RestController()
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
  public Person getPerson(UUID uuid){
    return personRepository.findOne(uuid);
  }
}
