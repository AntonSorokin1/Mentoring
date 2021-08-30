package database.api.controllers;

import static database.constans.URL.GET_TEACHERS_BY_TITLE;
import static database.constans.URL.GET_BY_NAME;
import static database.constans.URL.GET_BY_SURNAME;
import static database.constans.URL.TEACHERS;
import static org.springframework.http.ResponseEntity.ok;

import database.api.services.TeacherService;
import database.entities.Teacher;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(TEACHERS)
public class TeacherController extends CrudController<Teacher, TeacherService> {

  @GetMapping(GET_BY_NAME)
  public ResponseEntity<Teacher> getTeacherByName(@RequestParam String name) {
    return ok(service.getTeacherByName(name));
  }

  @GetMapping(GET_BY_SURNAME)
  public ResponseEntity<Teacher> getTeacherBySurname(@RequestParam String surname) {
    return ok(service.getTeacherBySurname(surname));
  }

  @GetMapping(GET_TEACHERS_BY_TITLE)
  public ResponseEntity<List<Teacher>> getTeachersByTitle(@RequestParam String teacherTitle) {
    return ok(service.getTeachersByTitle(teacherTitle));
  }
}
