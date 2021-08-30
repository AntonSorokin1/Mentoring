package database.api.repositories;

import database.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
  Student findByName(String name);

  Student findBySurname(String surname);

  Student findByPhoneNumber(String phoneNumber);
}
