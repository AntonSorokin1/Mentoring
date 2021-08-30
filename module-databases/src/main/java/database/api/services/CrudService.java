package database.api.services;

import java.util.List;

public interface CrudService <T>{
  T create(T object);

  List<T> readAll();

  T read(Long id);

  boolean update(T object, Long id);

  boolean delete(Long id);
}
