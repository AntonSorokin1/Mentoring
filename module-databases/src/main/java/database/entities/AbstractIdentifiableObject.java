package database.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractIdentifiableObject {
  @Id
  @Column(nullable = false)
  @GeneratedValue(strategy = IDENTITY)
  private Long id;

  @Column(nullable = false)
  private LocalDate created;

  @Column(nullable = false)
  private LocalDate updated;
}
