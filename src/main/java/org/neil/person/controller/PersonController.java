package org.neil.person.controller;

import org.neil.person.model.Person;
import org.neil.person.service.PersonService;
import org.neil.person.service.RandomPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by neilsharpe on 1/1/16.
 */
@RestController()
@RequestMapping(value="/person")
public class PersonController {

  private final PersonService personService;
  private RandomPersonService randomPersonService = new RandomPersonService();

  @Autowired
  public PersonController(PersonService personService) {
    if( personService == null){
      throw new NullPointerException("Person controller could not be setup");
    }
    this.personService = personService;
  }

  @RequestMapping(value="/", method = RequestMethod.GET)
  public String index() {
    return "Welcome to the Person Service";
  }

  @RequestMapping(value="/randomize",method = RequestMethod.POST)
  public Person createRandomPerson(){
    return personService.save(randomPersonService.generate());
  }

  @RequestMapping(value="/{id}", method = RequestMethod.GET)
  public Person getPerson(@PathVariable Long id){
    return personService.findOne(id);
  }

  @RequestMapping( method = RequestMethod.GET)
  public List<Person> getPersons(@RequestParam("id") Collection<Long> ids){
    return personService.findPersons(ids).collect(Collectors.toList());
  }

  @RequestMapping( method = RequestMethod.POST,consumes="application/json")
  public Person createPerson(@RequestBody Person p){
    return personService.save(p);
  }

  @RequestMapping(value="/{id}",method = RequestMethod.PUT,consumes="application/json")
  public Person updatePerson(@RequestBody Person p, @PathVariable Long id){
    return personService.updatePesron(id,p);
  }

  @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
  public void deletePerson(@PathVariable Long id){
    personService.delete(id);
  }
}
