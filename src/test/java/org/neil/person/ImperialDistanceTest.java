package org.neil.person;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by neilsharpe on 1/6/16.
 */
public class ImperialDistanceTest {
  @Test
  public void testConstructor(){
    ImperialDistance i = ImperialDistance.of(1,2);
    assertEquals(1,i.getFeet().intValue());
    assertEquals(2,i.getInches().intValue());
  }

  @Test
  public void testFeetSetters(){
    ImperialDistance i = ImperialDistance.of(1l);
    assertEquals(0,i.getFeet().intValue());
    assertEquals(1,i.getInches().intValue());

    i.setFeet(2l);
    assertEquals(2,i.getFeet().intValue());
    assertEquals(1,i.getInches().intValue());

    i.setFeet(5l);
    assertEquals(5,i.getFeet().intValue());
    assertEquals(1,i.getInches().intValue());
  }

  @Test
  public void testInchSetters(){
    ImperialDistance i = ImperialDistance.of(12l);
    assertEquals(1,i.getFeet().intValue());
    assertEquals(0,i.getInches().intValue());

    i.setInches(2l);
    assertEquals(1,i.getFeet().intValue());
    assertEquals(2,i.getInches().intValue());

    i.setInches(5l);
    assertEquals(1,i.getFeet().intValue());
    assertEquals(5,i.getInches().intValue());
  }
}
