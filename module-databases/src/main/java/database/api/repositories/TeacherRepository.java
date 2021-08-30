package database.api.repositories;

import database.entities.Teacher;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
  Teacher findByName(String name);

  Teacher findBySurname(String surname);

  List<Teacher> findByTitle(String title);
}
