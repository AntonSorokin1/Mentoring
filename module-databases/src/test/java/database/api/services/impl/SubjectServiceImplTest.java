package database.api.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import database.api.repositories.SubjectRepository;
import database.entities.Subject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

class SubjectServiceImplTest {

  @Mock
  private SubjectRepository repository;
  @Mock
  private Subject subject;

  @InjectMocks
  private SubjectServiceImpl service;

  @BeforeEach
  void init() {
    openMocks(this);
  }

  @Test
  void getSubjectByNameTest() {
    when(repository.findByName(anyString())).thenReturn(subject);
    assertEquals(subject, service.getSubjectByName(anyString()));
  }

  @Test
  void getSubjectByTeacherIdTest() {
    when(repository.findByTeacherId(anyLong())).thenReturn(subject);
    assertEquals(subject, service.getSubjectByTeacherId(anyLong()));
  }
}
