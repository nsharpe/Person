package org.neil.person.datasource;

import org.neil.person.model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * This instance of {@link CrudRepository} provides default implementations for
 * basic create read update and delete functionality.  This is auto populated by
 * the spring boot application.
 *
 * Created by neilsharpe on 1/1/16.
 */
public interface PersonRepository extends CrudRepository<Person, UUID> {
}
