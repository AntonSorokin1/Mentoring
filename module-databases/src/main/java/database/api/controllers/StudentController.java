package database.api.controllers;

import static database.constans.URL.GET_BY_NAME;
import static database.constans.URL.GET_BY_SURNAME;
import static database.constans.URL.GET_STUDENT_BY_PHONE_NUMBER;
import static database.constans.URL.STUDENTS;
import static org.springframework.http.ResponseEntity.ok;

import database.api.services.StudentService;
import database.entities.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(STUDENTS)
public class StudentController extends CrudController<Student, StudentService> {

  @GetMapping(GET_BY_NAME)
  public ResponseEntity<Student> getStudentByName(@RequestParam String name) {
    return ok(service.getStudentByName(name));
  }

  @GetMapping(GET_BY_SURNAME)
  public ResponseEntity<Student> getStudentBySurname(@RequestParam String surname) {
    return ok(service.getStudentBySurname(surname));
  }

  @GetMapping(GET_STUDENT_BY_PHONE_NUMBER)
  public ResponseEntity<Student> getStudentByPhoneNumber(@RequestParam String phoneNumber) {
    return ok(service.getStudentByPhoneNumber(phoneNumber));
  }
}
