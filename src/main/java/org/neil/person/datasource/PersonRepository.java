package org.neil.person.datasource;

import org.neil.person.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * Created by neilsharpe on 1/1/16.
 */
public interface PersonRepository extends CrudRepository<Person, UUID> {
}
