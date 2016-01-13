package org.neil.person.model;

import org.neil.person.service.PersonStatisticsService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by neilsharpe on 1/12/16.
 */
public class PersonStatistics {
  private LocalDate averageDateOfBirth;
  private Map<Integer,Long> ageDistribution;
  private Map<Person.Gender,LocalDate> averageDateOfBirthByGender;
  private Map<Person.Gender,Long> genderDistribution;

  public PersonStatistics(Stream<Person> personStream){
    this(personStream.collect(Collectors.toList()));
  }

  public PersonStatistics(Collection<Person> persons){
    PersonStatisticsService personStatistics = new PersonStatisticsService();
    ageDistribution = personStatistics.ageDistribution(persons.stream());
    averageDateOfBirth = personStatistics.averageBirthdate(persons.stream());
    averageDateOfBirthByGender = personStatistics.averageBirthDateByGender(persons.stream());
    genderDistribution = personStatistics.genderDistribution(persons.stream());
  }

  public LocalDate getAverageDateOfBirth() {
    return averageDateOfBirth;
  }

  public void setAverageDateOfBirth(LocalDate averageDateOfBirth) {
    this.averageDateOfBirth = averageDateOfBirth;
  }

  public Map<Integer, Long> getAgeDistribution() {
    return ageDistribution;
  }

  public void setAgeDistribution(Map<Integer, Long> ageDistribution) {
    this.ageDistribution = ageDistribution;
  }

  public Map<Person.Gender, LocalDate> getAverageDateOfBirthByGender() {
    return averageDateOfBirthByGender;
  }

  public void setAverageDateOfBirthByGender(Map<Person.Gender, LocalDate> averageDateOfBirthByGender) {
    this.averageDateOfBirthByGender = averageDateOfBirthByGender;
  }

  public Map<Person.Gender, Long> getGenderDistribution() {
    return genderDistribution;
  }

  public void setGenderDistribution(Map<Person.Gender, Long> genderDistribution) {
    this.genderDistribution = genderDistribution;
  }
}
