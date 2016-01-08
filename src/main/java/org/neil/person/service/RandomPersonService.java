package org.neil.person.service;

import org.neil.person.ImperialDistance;
import org.neil.person.model.Person;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * Created by neilsharpe on 1/7/16.
 */
public class RandomPersonService {
  Random random = new Random();
  private List<String> maleName = Arrays.asList(
          "Neil",
          "Mark",
          "Joe",
          "Sam",
          "Louise",
          "Samantha",
          "Corey",
          "John",
          "Chris",
          "George",
          "James",
          "Carl",
          "Jake"
  );
  private List<String> femaleName = Arrays.asList(
          "Alice",
          "Sarah",
          "Anna",
          "Victoria",
          "Melissa",
          "Lora",
          "Lisa",
          "Linda",
          "Jaquie",
          "Paula",
          "Roberta",
          "Michelle",
          "Natalie"
  );
  private List<String> lastName = Arrays.asList(
          "Smith",
          "Wong",
          "Lu",
          "Johnson",
          "Cobain",
          "Rockerfella",
          "Armstrong",
          "Alderan",
          "O'Connel"
  );
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

  public LocalDate generateBirthDate(){
    return LocalDate.now().minus(16l, ChronoUnit.YEARS ).minus(random.nextInt( 365 * 50),ChronoUnit.DAYS);
  }

  public String random(List<String> list){
    return list.get(random.nextInt(list.size()));
  }
}
