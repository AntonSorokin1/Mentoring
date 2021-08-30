package database.api.services.impl;

import database.api.repositories.SubjectRepository;
import database.api.services.SubjectService;
import database.entities.Subject;
import org.springframework.stereotype.Service;

@Service
public class SubjectServiceImpl extends CrudServiceImpl<Subject, SubjectRepository> implements
    SubjectService {

  @Override
  public Subject getSubjectByName(String name) {
    return repository.findByName(name);
  }

  @Override
  public Subject getSubjectByTeacherId(Long teacherId) {
    return repository.findByTeacherId(teacherId);
  }
}
