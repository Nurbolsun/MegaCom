package kg.cinematica.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    LocalTime startTime;
    LocalDate startDate;

    LocalDateTime addDate;
    LocalDateTime updateDate;
    boolean active;

    @PrePersist
    protected void onCreate() {
        addDate = LocalDateTime.now();
        updateDate = LocalDateTime.now();
        active = true;
    }


}
