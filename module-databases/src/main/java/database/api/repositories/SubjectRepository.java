package database.api.repositories;

import database.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
  Subject findByName(String name);

  Subject findByTeacherId(Long teacherId);
}
