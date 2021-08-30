package database.api.services.impl;

import database.api.repositories.TeacherRepository;
import database.api.services.TeacherService;
import database.entities.Teacher;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl extends CrudServiceImpl<Teacher, TeacherRepository> implements
    TeacherService {

  @Override
  public Teacher getTeacherByName(String name) {
    return repository.findByName(name);
  }

  @Override
  public Teacher getTeacherBySurname(String surname) {
    return repository.findBySurname(surname);
  }

  @Override
  public List<Teacher> getTeachersByTitle(String teacherTitle) {
    return repository.findByTitle(teacherTitle);
  }
}
