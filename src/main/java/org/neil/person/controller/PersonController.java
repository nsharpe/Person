package org.neil.person.controller;

import org.neil.person.datasource.PersonRepository;
import org.neil.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by neilsharpe on 1/1/16.
 */
@RestController()
@RequestMapping(value="/person")
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
  public Person getPerson(@PathVariable Long id){
    return personRepository.findOne(id);
  }

  @RequestMapping( method = RequestMethod.POST,consumes="application/json")
  public Person createPerson(@RequestBody Person p){
    return personRepository.save(p);
  }

  @RequestMapping(value="/{id}",method = RequestMethod.PUT,consumes="application/json")
  public Person updatePerson(@RequestBody Person p, @PathVariable Long id){
    if(p.getId()==null){
      p.setId(id);
    }
    return personRepository.save(p);
  }

  @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
  public void deletePerson(@PathVariable Long id){
    personRepository.delete(id);
  }
}
