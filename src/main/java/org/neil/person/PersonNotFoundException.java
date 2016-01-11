package org.neil.person;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by neilsharpe on 1/9/16.
 */
@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such person")
public class PersonNotFoundException extends IllegalStateException {

  public PersonNotFoundException(Long id){
    super("Could not find person with id="+id);
  }
}
