package org.neil.util;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Denotes that a class has a uniqueness constraint.
 *
 */
@FunctionalInterface
public interface Unique<I> {

  I getId();

  /**
   * Filters the object based off of the unique Identifier provided by {@link Unique#getId()}
   *
   * @param stream
   * @param function
   * @param <E>
   * @return
   */
  <E> Stream<E> matchesId(Stream<E> stream, Function<E,I> function);
}
