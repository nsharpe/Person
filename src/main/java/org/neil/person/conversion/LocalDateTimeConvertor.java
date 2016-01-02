package org.neil.person.conversion;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Converter(autoApply = true)
public class LocalDateTimeConvertor implements AttributeConverter<LocalDateTime, Date>
{

  @Override
  public Date convertToDatabaseColumn(LocalDateTime date) {
    return Date.from(Instant.from(date));
  }

  @Override
  public LocalDateTime convertToEntityAttribute(Date value) {
    return LocalDateTime.from(value.toInstant());
  }
}
