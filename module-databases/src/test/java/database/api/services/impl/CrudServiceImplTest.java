package database.api.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

import database.entities.AbstractIdentifiableObject;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.jpa.repository.JpaRepository;

class CrudServiceImplTest<T extends AbstractIdentifiableObject, R extends JpaRepository<T, Long>> {

  private List<T> list;

  @Mock
  private R repository;
  @Mock
  private T object;

  @InjectMocks
  private CrudServiceImpl<T, R> service;

  @BeforeEach
  void init() {
    openMocks(this);
    list = List.of(object);
  }

  @Test
  void createTest() {
    assertEquals(object, service.create(object));
  }

  @Test
  void readTest() {
    when(repository.findById(anyLong())).thenReturn(Optional.of(object));
    assertEquals(object, service.read(anyLong()));
  }

  @Test
  void readNullTest() {
    when(repository.findById(anyLong())).thenReturn(null);
    assertThrows(NullPointerException.class, () -> service.read(1L));
  }

  @Test
  void readAllTest() {
    when(repository.findAll()).thenReturn(list);
    assertEquals(list, service.readAll());
  }

  @Test
  void updateExistTest() {
    when(repository.existsById(anyLong())).thenReturn(true);
    assertTrue(service.update(object, anyLong()));
  }

  @Test
  void updateNotExistTest() {
    when(repository.existsById(anyLong())).thenReturn(false);
    assertFalse(service.update(object, anyLong()));
  }

  @Test
  void deleteExistTest() {
    when(repository.existsById(anyLong())).thenReturn(true);
    assertTrue(service.delete(anyLong()));
  }

  @Test
  void deleteNotExistTest() {
    when(repository.existsById(anyLong())).thenReturn(false);
    assertFalse(service.delete(anyLong()));
  }
}
