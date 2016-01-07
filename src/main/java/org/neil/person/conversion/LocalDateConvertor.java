package org.neil.person.conversion;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;

/**
 * Allows the database to correctly convert the {@link java.time.LocalDate} object
 */
@Converter(autoApply = true)
public class LocalDateConvertor implements AttributeConverter<LocalDate, Date> {

  @Override
  public Date convertToDatabaseColumn(LocalDate date) {
    return Date.from(Instant.from(date));
  }

  @Override
  public LocalDate convertToEntityAttribute(Date value) {
    return LocalDate.from(value.toInstant());
  }
}
