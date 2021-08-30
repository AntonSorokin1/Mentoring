package database.api.services.impl;

import static java.time.LocalDate.now;

import database.api.services.CrudService;
import database.entities.AbstractIdentifiableObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class CrudServiceImpl<T extends AbstractIdentifiableObject, R extends JpaRepository<T, Long>>
    implements CrudService<T> {
  @Autowired
  protected R repository;

  @Override
  public T create(T object) {
    if (object.getCreated() == null) {
      object.setCreated(now());
    }
    if (object.getUpdated() == null) {
      object.setUpdated(now());
    }
    repository.save(object);
    return object;
  }

  @Override
  public List<T> readAll() {
    return repository.findAll();
  }

  @Override
  public T read(Long id) {
    return repository.findById(id).orElse(null);
  }

  @Override
  public boolean update(T object, Long id) {
    if (repository.existsById(id)) {
      object.setId(id);
      object.setUpdated(now());
      repository.save(object);
      return true;
    }
    return false;
  }

  @Override
  public boolean delete(Long id) {
    if (repository.existsById(id)) {
      repository.deleteById(id);
      return true;
    }
    return false;
  }
}
