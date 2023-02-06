package kg.cinematica.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity //таблица postgres
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //генерация key
    Long id;
    String def;
    String name;
    String image;
    Double rating;
    String pg;
    Date addDate;
    Date updateDate;
    boolean active;

    @PrePersist
    protected void onCreate() {
        active = true;
    }
}
