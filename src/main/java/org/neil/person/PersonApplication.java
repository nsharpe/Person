package org.neil.person;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is the bootstrap for the Person webservice.  The
 * {@link SpringBootApplication} annotation assignees beans automaticaly for all
 * items contained in the package org.neil.person
 *
 * It also updates properties accordingly.
 *
 * Created by neilsharpe on 1/1/16.
 */
@SpringBootApplication
public class PersonApplication {

  public static void main(String args[]){
    //This starts the rest service
    SpringApplication.run(PersonApplication.class, args);
  }
}
