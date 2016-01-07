package org.neil.person;

import java.util.Objects;

/**
 * Provides a length in the imperial system.
 *
 */
public class ImperialDistance implements Comparable<ImperialDistance> {
  private Long inches;

  public ImperialDistance(){
    inches = 0l;
  }

  private ImperialDistance(Long inches){
    this.inches = Long.valueOf(inches);
  }

  public Long getFeet() {
    return inches / 12;
  }

  public void setFeet(Long feet){
    inches = inches % 12;
    inches += feet * 12;
  }

  public Long getInches() {
    return inches % 12;
  }

  public void setInches(Long i){
    this.inches = (this.inches / 12) * 12;
    this.inches += i;
  }

  public ImperialDistance plus(ImperialDistance toAdd){
    return of(inches+toAdd.inches);
  }

  public ImperialDistance subtract(ImperialDistance subtract){
    return of(inches-subtract.inches);
  }

  public static ImperialDistance of(Integer feet, Integer inches){
    return of(feet.longValue(),inches.longValue());
  }

  public static ImperialDistance of(Long feet, Long inches){
    return of((feet * 12) + inches);
  }

  public static ImperialDistance of(Long inches){
    return new ImperialDistance(inches);
  }

  @Override
  public int compareTo(ImperialDistance o) {
    if(inches > o.inches )
      return 1;
    if(inches < o.inches )
      return -1;

    return 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ImperialDistance length = (ImperialDistance) o;
    return Objects.equals(inches, length.inches);
  }

  @Override
  public int hashCode() {
    return Objects.hash(inches);
  }
}
