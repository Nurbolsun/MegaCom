package kg.cinematica.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //таблица postgres
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table (name = "tb_room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    Cinema cinema;

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
