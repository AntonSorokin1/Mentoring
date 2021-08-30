package database.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@Entity
@Table(name = "subjects")
public class Subject extends AbstractIdentifiableObject {
  @Column(nullable = false)
  private String name;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "teacher_id", referencedColumnName = "id")
  private Teacher teacher;
}
