package database.api.services;

import database.entities.Teacher;
import java.util.List;

public interface TeacherService extends CrudService<Teacher> {
  Teacher getTeacherByName(String name);

  Teacher getTeacherBySurname(String surname);

  List<Teacher> getTeachersByTitle(String teacherTitle);
}
