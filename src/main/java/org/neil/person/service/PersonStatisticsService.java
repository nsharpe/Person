package org.neil.person.service;

import org.neil.person.model.Person;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by neilsharpe on 1/10/16.
 */
public class PersonStatisticsService {

  /**
   * returns a map with age as the key, and number of people as the value.
   *
   * In otherwords the number of people of a given age is returned.
   *
   * @param personStream
   * @return
   */
  public Map<Integer,Long> ageDistribution(Stream<Person> personStream){
    return personStream.map( Person.age() )
            .collect(groupingBy( x->x ,counting() ) );
  }

  /**
   * Returns a map that has the number of persons that are a given gender
   *
   * @param personStream
   * @return
   */
  public Map<Person.Gender,Long> genderDistribution(Stream<Person> personStream){
    return personStream
            .collect(
                    groupingBy( Person::getGender,counting() ) );
  }

  /**
   * Returns the average birthdate of a given gender
   *
   * @param person
   * @return
   */
  public Map<Person.Gender,LocalDate> averageBirthDateByGender(Stream<Person> person){
    return person.collect(groupingBy(Person::getGender,
            Collectors.averagingInt( x -> Person.daysSinceBirth().apply(x) )))
            .entrySet()
            .stream()
            .collect(Collectors.toMap(x-> x.getKey(),
                    x-> LocalDate.now().minus(x.getValue().longValue(),ChronoUnit.DAYS)));
  }

  /**
   * returns the average birthdate for all persons.
   * @param persons
   * @return
   */
  public LocalDate averageBirthdate(Stream<Person> persons){
    Double avg  = persons.map( Person.daysSinceBirth() )
            .mapToInt( x -> x )
            .average().getAsDouble();
    return LocalDate.now().minus(avg.longValue(), ChronoUnit.DAYS);
  }

}
