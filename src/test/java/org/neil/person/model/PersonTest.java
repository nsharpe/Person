package org.neil.person.model;

import org.junit.Test;
import org.neil.person.service.RandomPersonService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by neilsharpe on 1/7/16.
 */
public class PersonTest {

  @Test
  public void testOlderThanPredicate(){
    // Setup a person born 17 years ago
    Person toTest = new Person();
    toTest.setBirthDate(LocalDate.now().minus(17, ChronoUnit.YEARS));

    LocalDate eightTeenYearsAgo = LocalDate.now().minus(18,ChronoUnit.YEARS);
    LocalDate sixTeenYearsAgo = LocalDate.now().minus(16,ChronoUnit.YEARS);

    // assert person is not older then eighteen years ago
    assertFalse(Person.isOlderThan(eightTeenYearsAgo).test(toTest));

    assertTrue(Person.isOlderThan(sixTeenYearsAgo).test(toTest));
  }

  @Test
  public void testIsAdult(){
    Predicate<Person> isAdult = Person.isAnAdult();

    Person toTest = new Person();

    // Test that a 17 year old is not an adult
    toTest.setBirthDate(LocalDate.now().minus(17, ChronoUnit.YEARS));
    assertFalse(isAdult.test(toTest));

    //Test that an 18 year old is an adult
    toTest.setBirthDate(LocalDate.now().minus(18,ChronoUnit.YEARS));
    assertTrue(isAdult.test(toTest));
  }

  @Test
  public void testWeighsMoreThan(){
    Predicate<Person> weighsMoreThanTenPounds = Person.weighsMoreThan(BigDecimal.TEN);

    Person p = new Person();
    p.setWeightInPounds(BigDecimal.valueOf(11.1));

    assertTrue(weighsMoreThanTenPounds.test(p));

  }

  /**
   * This tests that matches id functionality provided by the
   * {@link org.neil.util.Unique} interface is operational
   */
  @Test
  public void personUniquePredicate(){
    // Create a person with an id of 3
    Person p = new Person();
    p.setId(3l);

    Supplier<Long> longContainer = () -> 3l;

    Optional<Supplier<Long>> result
            = p.matchesId(Stream.of(longContainer),x->x.get()).findFirst();

    assertEquals(longContainer,result.get());
  }

  @Test
  public void testSortByIdLessThan(){
    Person p1 = new Person();
    p1.setId(1l);

    Person p2 = new Person();
    p2.setId(2l);

    assertTrue(Person.sortById().compare(p1,p2) < 0 );
  }

  @Test
  public void testSortByIdEquals(){
    Person p1 = new Person();
    p1.setId(1l);

    Person p2 = new Person();
    p2.setId(1l);

    assertTrue(Person.sortById().compare(p1,p2) == 0 );
  }

  @Test
  public void testSortByGreaterThan(){
    Person p1 = new Person();
    p1.setId(2l);

    Person p2 = new Person();
    p2.setId(1l);

    assertTrue(Person.sortById().compare(p1,p2) > 0 );
  }

  @Test
  public void testSortByNameLastNameDifferent(){
    Person p1 = new Person();
    p1.setFirstName("Albert");
    p1.setLastName("Smith");

    Person p2 = new Person();
    p2.setFirstName("Mike");
    p2.setLastName("Blair");

    assertTrue(Person.sortByName().compare(p1,p2) > 0 );
  }

  @Test
  public void testSortByNameLastNameSame(){
    Person p1 = new Person();
    p1.setId(1l);
    p1.setFirstName("Albert");
    p1.setLastName("Smith");

    Person p2 = new Person();
    p2.setId(1l);
    p2.setFirstName("Mike");
    p2.setLastName("Smith");

    assertTrue(Person.sortByName().compare(p1,p2) < 0 );
  }

  @Test
  public void testSortByNameNameSame(){
    Person p1 = new Person();
    p1.setId(1l);
    p1.setFirstName("Albert");
    p1.setLastName("Smith");

    Person p2 = new Person();
    p2.setId(2l);
    p2.setFirstName("Albert");
    p2.setLastName("Smith");

    assertTrue(Person.sortByName().compare(p1,p2) < 0 );
  }
}
