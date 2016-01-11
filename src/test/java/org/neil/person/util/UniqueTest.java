package org.neil.person.util;

import org.junit.Test;
import org.neil.util.Unique;

import java.util.Optional;
import java.util.stream.IntStream;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by neilsharpe on 1/7/16.
 */
public class UniqueTest {

  @Test
  public void testMatchesId(){
    Unique<Integer> identifier = () -> 3;

    Optional<Integer> foundInt = identifier.matchesId( IntStream.range(0,5)
            .mapToObj(x->x),x->x).findFirst();
    assertEquals(foundInt.get().intValue(),3);
  }
}
