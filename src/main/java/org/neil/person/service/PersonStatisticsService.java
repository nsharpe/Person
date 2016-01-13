package org.neil.person.service;

import org.neil.person.model.Person;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by neilsharpe on 1/10/16.
 */
public class PersonStatisticsService {

  public Map<Integer,Long> ageDistribution(Stream<Person> personStream){
    return personStream.map( age() )
            .collect(groupingBy(x->x,counting()));
  }

  public Map<Person.Gender,Long> genderDistribution(Stream<Person> personStream){
    return personStream
            .collect(
                    groupingBy( Person::getGender,counting() ) );
  }

  public Map<Person.Gender,LocalDate> averageBirthDateByGender(Stream<Person> person){
    return person.collect(groupingBy(Person::getGender,
            Collectors.averagingInt(x->daysSinceBirthDay(x))))
            .entrySet()
            .stream()
            .collect(Collectors.toMap(x-> x.getKey(),
                    x-> LocalDate.now().minus(x.getValue().longValue(),ChronoUnit.DAYS)));
  }

  public LocalDate averageBirthdate(Stream<Person> persons){
    Double avg  = persons.mapToInt( x -> daysSinceBirthDay(x) )
            .average().getAsDouble();
    return LocalDate.now().minus(avg.longValue(), ChronoUnit.DAYS);
  }

  public static Integer daysSinceBirthDay(Person p){
    return daysSinceBirth().apply(p);
  }

  public static Function<Person,Integer> daysSinceBirth(){
    return x -> Period.between(x.getBirthDate(),LocalDate.now()).getDays();
  }

  public static Function<Person,Integer> age(){
    return x -> LocalDate.now().getYear() - x.getBirthDate().getYear();
  }

}
