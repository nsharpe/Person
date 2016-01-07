package org.neil.person.conversion;

import org.neil.person.ImperialDistance;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converts a {@link ImperialDistance} object into a database value.
 */
@Converter(autoApply = true)
public class LengthConvertor implements AttributeConverter<ImperialDistance,Long> {

  @Override
  public Long convertToDatabaseColumn(ImperialDistance attribute) {
    return (attribute.getFeet() * 12) + attribute.getInches();
  }

  @Override
  public ImperialDistance convertToEntityAttribute(Long dbData) {
    return ImperialDistance.of(dbData);
  }
}
