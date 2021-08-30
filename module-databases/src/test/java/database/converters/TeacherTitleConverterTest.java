package database.converters;

import static database.entities.TeacherTitle.TEACHER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.MockitoAnnotations.openMocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

class TeacherTitleConverterTest {

  @InjectMocks
  private TeacherTitleConverter converter;

  @BeforeEach
  public void init() {
    openMocks(this);
  }

  @Test
  void convertToDatabaseColumnTest() {
    assertEquals(TEACHER.toString(), converter.convertToDatabaseColumn(TEACHER));
  }

  @Test
  void convertToEntityAttributeTest() {
    assertEquals(TEACHER, converter.convertToEntityAttribute(TEACHER.toString()));
  }
}
