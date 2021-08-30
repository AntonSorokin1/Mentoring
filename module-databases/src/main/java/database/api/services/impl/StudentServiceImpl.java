package database.api.services.impl;

import database.api.repositories.StudentRepository;
import database.api.services.StudentService;
import database.entities.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl extends CrudServiceImpl<Student, StudentRepository> implements
    StudentService {

  @Override
  public Student getStudentByName(String name) {
    return repository.findByName(name);
  }

  @Override
  public Student getStudentBySurname(String surname) {
    return repository.findBySurname(surname);
  }

  @Override
  public Student getStudentByPhoneNumber(String phoneNumber) {
    return repository.findByPhoneNumber(phoneNumber);
  }
}
