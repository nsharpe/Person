package org.neil.person.datasource;

import org.neil.person.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created by neilsharpe on 1/1/16.
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, UUID> {
}
