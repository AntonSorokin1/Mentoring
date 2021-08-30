package database.api.services.impl;

import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import database.api.repositories.TeacherRepository;
import database.entities.Teacher;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class TeacherServiceImplTest {

  private List<Teacher> list;
  @Mock
  private TeacherRepository repository;
  @Mock
  private Teacher teacher;

  @InjectMocks
  private TeacherServiceImpl service;

  @BeforeEach
  void init() {
    openMocks(this);
    list = of(teacher);
  }

  @Test
  void getTeacherByNameTest() {
    when(repository.findByName(anyString())).thenReturn(teacher);
    assertEquals(teacher, service.getTeacherByName(anyString()));
  }

  @Test
  void getTeacherBySurnameTest() {
    when(repository.findBySurname(anyString())).thenReturn(teacher);
    assertEquals(teacher, service.getTeacherBySurname(anyString()));
  }

  @Test
  void getTeachersByTitleTest() {
    when(repository.findByTitle(anyString())).thenReturn(list);
    assertEquals(list, service.getTeachersByTitle(anyString()));
  }
}
