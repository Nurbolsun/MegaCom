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
@Table(name = "tb_cinema")
public class Cinema {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String address;
    String photoLink;
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
