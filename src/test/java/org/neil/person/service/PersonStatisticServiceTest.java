package org.neil.person.service;

import org.junit.Test;
import org.neil.person.model.Person;

import java.time.LocalDate;
import java.util.Map;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by neilsharpe on 1/12/16.
 */
public class PersonStatisticServiceTest {

  public PersonStatisticsService personStatisticsService
          = new PersonStatisticsService();

  @Test
  public void testGenderDistribution(){
    Person male1 = new Person();
    male1.setFirstName("First Male");
    male1.setGender(Person.Gender.MALE);

    Person male2 = new Person();
    male2.setFirstName("Second Male");
    male2.setGender(Person.Gender.MALE);

    Person female = new Person();
    female.setFirstName("First Female");
    female.setGender(Person.Gender.FEMALE);

    Map<Person.Gender,Long> distribution
            = personStatisticsService.genderDistribution(Stream.of(male1, male2, female));
    assertNotNull(distribution);
    assertEquals(2L,distribution.get(Person.Gender.MALE).longValue());
    assertEquals(1L,distribution.get(Person.Gender.FEMALE).longValue());
  }

  @Test
  public void testAverageBirthDateGenderDistribution(){
    Person male1 = new Person();
    male1.setFirstName("First Male");
    male1.setGender(Person.Gender.MALE);
    male1.setBirthDate(LocalDate.now().minusDays(3));

    Person male2 = new Person();
    male2.setFirstName("Second Male");
    male2.setGender(Person.Gender.MALE);
    male2.setBirthDate(LocalDate.now().minusDays(2));

    Person male3 = new Person();
    male3.setFirstName("Second Male");
    male3.setGender(Person.Gender.MALE);
    male3.setBirthDate(LocalDate.now().minusDays(1));

    Person female1 = new Person();
    female1.setFirstName("First Female");
    female1.setGender(Person.Gender.FEMALE);
    female1.setBirthDate(LocalDate.now().minusDays(12));

    Person female2 = new Person();
    female2.setFirstName("Second Female");
    female2.setGender(Person.Gender.FEMALE);
    female2.setBirthDate(LocalDate.now().minusDays(2));

    Person female3 = new Person();
    female3.setFirstName("Second Female");
    female3.setGender(Person.Gender.FEMALE);
    female3.setBirthDate(LocalDate.now().minusDays(1));

    LocalDate averageMaleDaysAgo = LocalDate.now().minusDays(2);
    LocalDate averageFemaleDaysAgo = LocalDate.now().minusDays(5);

    Map<Person.Gender,LocalDate> result
            = personStatisticsService.averageBirthDateByGender(
            Stream.of(male1,male2,male3,female1,female2,female3));

    assertEquals(averageMaleDaysAgo,result.get(Person.Gender.MALE));
    assertEquals(averageFemaleDaysAgo,result.get(Person.Gender.FEMALE));
  }

  @Test
  public void testAgeDistrubtion(){
    Person p1 = new Person();
    p1.setBirthDate(LocalDate.now().minusYears(3));

    Person p2 = new Person();
    p2.setBirthDate(LocalDate.now().minusYears(3));

    Person p3 = new Person();
    p3.setBirthDate(LocalDate.now().minusYears(5));

    Map<Integer,Long> ageDistribution
            = personStatisticsService.ageDistribution(Stream.of(p1,p2,p3));
    assertNotNull(ageDistribution);
    assertEquals(2,ageDistribution.size());
    assertEquals(2,ageDistribution.get(3).intValue());
    assertEquals(1,ageDistribution.get(5).intValue());
  }

  @Test
  public void testAverageBirthDate(){
    Person p1 = new Person();
    p1.setBirthDate(LocalDate.now().minusDays(6));

    Person p2 = new Person();
    p2.setBirthDate(LocalDate.now().minusDays(2));

    Person p3 = new Person();
    p3.setBirthDate(LocalDate.now().minusDays(1));

    LocalDate averageBirthDay = personStatisticsService.averageBirthdate(
            Stream.of(p1,p2,p3)
    );

    assertEquals( LocalDate.now().minusDays(3),averageBirthDay );
  }
}
