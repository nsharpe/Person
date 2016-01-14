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

  }

  /**
   * Returns a map that has the number of persons that are a given gender
   *
   * @param personStream
   * @return
   */
  public Map<Person.Gender,Long> genderDistribution(Stream<Person> personStream){

  }

  /**
   * Returns the average birthdate of a given gender
   *
   * @param person
   * @return
   */
  public Map<Person.Gender,LocalDate> averageBirthDateByGender(Stream<Person> person){

  }

  /**
   * returns the average birthdate for all persons.
   * @param persons
   * @return
   */
  public LocalDate averageBirthdate(Stream<Person> persons){

  }

}
