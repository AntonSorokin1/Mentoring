package database.api.controllers;

import static database.constans.URL.GET_BY_NAME;
import static database.constans.URL.GET_SUBJECT_BY_TEACHER_ID;
import static database.constans.URL.SUBJECTS;
import static org.springframework.http.ResponseEntity.ok;

import database.api.services.SubjectService;
import database.entities.Subject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(SUBJECTS)
public class SubjectController extends CrudController<Subject, SubjectService> {

  @GetMapping(GET_BY_NAME)
  public ResponseEntity<Subject> getSubjectByName(@RequestParam String name) {
    return ok(service.getSubjectByName(name));
  }

  @GetMapping(GET_SUBJECT_BY_TEACHER_ID)
  public ResponseEntity<Subject> getSubjectByTeacherId(@RequestParam Long teacherId) {
    return ok(service.getSubjectByTeacherId(teacherId));
  }
}
