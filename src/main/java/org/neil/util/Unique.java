package org.neil.util;

import java.util.function.Predicate;

/**
 * Created by neilsharpe on 1/1/16.
 */
public interface Unique<I> {

  I getId();

  default Predicate<Unique<I>> idMatches(){
    return x -> x.getId().equals(getId());
  }

}
