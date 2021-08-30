package database.api.services;

import database.entities.Subject;

public interface SubjectService extends CrudService<Subject> {
  Subject getSubjectByName(String name);

  Subject getSubjectByTeacherId(Long teacherId);
}
