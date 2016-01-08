package org.neil.person.model;

import org.neil.person.ImperialDistance;
import org.neil.util.Unique;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.function.Predicate;

/**
 * This object represents a person and will be used by both the webservice and
 * dao layer.
 *
 * Created by neilsharpe on 1/1/16.
 */
@Entity
@Table(name="person")
public class Person implements Unique<Long> {

  @Id
  @GeneratedValue
  @Column(updatable = false)
  private Long id;

  @Column(nullable = false)
  private String firstName;

  @Column(nullable = false)
  private String lastName;

  @Column(nullable = false)
  private LocalDate birthDate;

  @Column(nullable = false)
  private BigDecimal weightInPounds;

  @Column(nullable = false)
  private ImperialDistance height;

  @Column(nullable=false)
  @Enumerated(EnumType.STRING)
  private Gender gender;

  @Override
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public BigDecimal getWeightInPounds() {
    return weightInPounds;
  }

  public void setWeightInPounds(BigDecimal weightInPounds) {
    this.weightInPounds = weightInPounds;
  }

  public ImperialDistance getHeight() {
    return height;
  }

  public void setHeight(ImperialDistance height) {
    this.height = height;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public enum Gender{
    MALE,FEMALE
  }

  /**
   * This collection of predicates is intended to make operations appear more
   * human readable.
   *
   * @param localDate
   * @return
   */
  public static Predicate<Person> isOlderThan(final LocalDate localDate){
    return x -> x.getBirthDate().isBefore(localDate);
  }

  public static Predicate<Person> isOlderThanOrEqual(final LocalDate localDate){
    return isOlderThan(localDate).or( x -> x.getBirthDate().isEqual(localDate));
  }

  public static Predicate<Person> isYoungerThan(final LocalDate localDate){
    return x -> x.getBirthDate().isAfter(localDate);
  }

  public static Predicate<Person> isAnAdult(){
    return isOlderThanOrEqual(LocalDate.now().minus(18, ChronoUnit.YEARS));
  }

  public static Predicate<Person> weighsMoreThan(BigDecimal weightInPounds){
    return x -> x.getWeightInPounds().compareTo(weightInPounds) > 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Person person = (Person) o;
    return Objects.equals(getId(), person.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }
}
