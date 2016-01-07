package org.neil.convertors;

import org.springframework.core.convert.converter.Converter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LocalDateConvertor implements Converter<String, LocalDate> {

  private final DateTimeFormatter formatter;

  public LocalDateConvertor(String dateFormat) {
    this.formatter = DateTimeFormatter.ofPattern(dateFormat);
  }

  @Override
  public LocalDate convert(String source) {
    if (source == null || source.isEmpty()) {
      return null;
    }

    return LocalDate.parse(source, formatter);
  }
}
