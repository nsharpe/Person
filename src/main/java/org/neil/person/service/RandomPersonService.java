package org.neil.person.service;

import org.neil.person.ImperialDistance;
import org.neil.person.model.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by neilsharpe on 1/7/16.
 */
public class RandomPersonService {
  Random random = new Random();
  private List<String> maleName = Stream.of(
          "Ted", "Thomas", "Adam", "Albert", "Arnold", "Barney", "Ben", "Bart",
          "Bill", "Brett", "Bryan", "Calvin", "Carl", "Clayton", "Cole", "Dale",
          "Dan", "David", "Ed", "Edwardo", "Elvis", "Eric", "Ernie", "Felix",
          "Frank", "Garfield", "Garret", "Grant", "Gus", "Harrison", "Harry",
          "Hubert", "Irwin", "Jack","Jean", "Neil", "Mark", "Joe", "Sam",
          "Louise", "Samantha", "Corey", "John", "Chris", "George", "James",
          "Carl", "Jake", "Fry"
  ).distinct().collect(Collectors.toList());
  private List<String> femaleName = Stream.of(
          "Abbey","Adriana","Alice","Allisa","Amanda", "Amy","Anabel","Angie",
          "Anna","Ariel","Audrey","Bailey","Bertha","Brittany","Candice",
          "Carla","Carman","Carole","Carrie","Celina","Cindy","Cinthia",
          "Clarrisa","Cleo","Cortney","Daisey","Debra","Dolly","Dora","Edda",
          "Elisabeth","Ellen", "Jaquie", "Lora", "Lisa", "Linda", "Melissa",
          "Michelle", "Natalie", "Paula", "Roberta", "Sarah", "Victoria"
  ).distinct().collect(Collectors.toList());
  private List<String> lastName = Stream.of(
          "Smith","Johnson", "Wong", "Lu", "Cobain", "Rockerfella", "Armstrong",
          "Alderan", "O'Connel", "Williams", "Brown","Jones","Miller","Garcia",
          "Martin","Moore","White","Jackson","Taylor","Lee","Harris", "Clark",
          "Robinson","Young","King","Scott","Green","Baker","Hill","Edwards"
  ).distinct().collect(Collectors.toList());;

  public Person generate(){
    Person toReturn = new Person();

    toReturn.setGender( random.nextBoolean() ? Person.Gender.FEMALE : Person.Gender.MALE);
    toReturn.setFirstName(toReturn.getGender() == Person.Gender.FEMALE ? random(femaleName) : random(maleName));
    toReturn.setLastName(random(lastName));
    toReturn.setBirthDate(generateBirthDate());
    toReturn.setHeight(ImperialDistance.of(random.nextInt(3) + 4,random.nextInt(12)));
    toReturn.setWeightInPounds(BigDecimal.valueOf(100 + ( random.nextDouble() * 150)));
    return toReturn;
  }

  public Stream<Person> generate(Integer count){
    return generate(count.longValue());
  }

  public Stream<Person> generate(Long count)
  {
    return LongStream.range(0,count).mapToObj(x->generate());
  }

  public LocalDate generateBirthDate(){
    return LocalDate.now().minus(16l, ChronoUnit.YEARS ).minus(random.nextInt( 365 * 50),ChronoUnit.DAYS);
  }

  public String random(List<String> list){
    return list.get(random.nextInt(list.size()));
  }
}
