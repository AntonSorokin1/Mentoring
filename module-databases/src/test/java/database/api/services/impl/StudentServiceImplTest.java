package database.api.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import database.api.repositories.StudentRepository;
import database.entities.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class StudentServiceImplTest {

  @Mock
  private StudentRepository repository;
  @Mock
  private Student student;

  @InjectMocks
  private StudentServiceImpl service;

  @BeforeEach
  void init() {
    openMocks(this);
  }

  @Test
  void getStudentByNameTest() {
    when(repository.findByName(anyString())).thenReturn(student);
    assertEquals(student, service.getStudentByName(anyString()));
  }

  @Test
  void getStudentBySurnameTest() {
    when(repository.findBySurname(anyString())).thenReturn(student);
    assertEquals(student, service.getStudentBySurname(anyString()));
  }

  @Test
  void getStudentByPhoneNumberTest() {
    when(repository.findByPhoneNumber(anyString())).thenReturn(student);
    assertEquals(student, service.getStudentByPhoneNumber(anyString()));
  }
}
