package database.api.controllers;

import static database.constans.URL.CREATE;
import static database.constans.URL.DELETE;
import static database.constans.URL.GET;
import static database.constans.URL.GET_ALL;
import static database.constans.URL.UPDATE;
import static org.springframework.http.ResponseEntity.ok;

import database.api.services.CrudService;
import database.entities.AbstractIdentifiableObject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping
public class CrudController<T extends AbstractIdentifiableObject, S extends CrudService<T>> {
  @Autowired
  protected S service;

  @PostMapping(CREATE)
  public ResponseEntity<T> create(@RequestBody T object) {
    return ok(service.create(object));
  }

  @GetMapping(GET_ALL)
  public ResponseEntity<List<T>> readAll() {
    return ok(service.readAll());
  }

  @GetMapping(GET)
  public ResponseEntity<T> read(@RequestParam Long id) {
    return ok(service.read(id));
  }

  @PutMapping(UPDATE)
  public ResponseEntity<Boolean> update(@RequestParam Long id, @RequestBody T object) {
    return ok(service.update(object, id));
  }

  @DeleteMapping(DELETE)
  public ResponseEntity<Boolean> delete(@RequestParam Long id) {
    return ok(service.delete(id));
  }
}
