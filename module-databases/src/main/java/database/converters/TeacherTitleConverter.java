package database.converters;

import database.entities.TeacherTitle;
import java.util.stream.Stream;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class TeacherTitleConverter implements AttributeConverter<TeacherTitle, String> {

  @Override
  public String convertToDatabaseColumn(TeacherTitle attribute) {
    return attribute.toString();
  }

  @Override
  public TeacherTitle convertToEntityAttribute(String dbData) {
    return Stream.of(TeacherTitle.values())
        .filter(t -> t.toString().equals(dbData))
        .findFirst()
        .orElseThrow(IllegalArgumentException::new);
  }
}
