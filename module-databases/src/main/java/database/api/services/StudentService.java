package database.api.services;

import database.entities.Student;

public interface StudentService extends CrudService<Student> {
  Student getStudentByName(String name);

  Student getStudentBySurname(String surname);

  Student getStudentByPhoneNumber(String phoneNumber);
}
