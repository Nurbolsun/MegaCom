package kg.cinematica.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "tb_room_movie_price")
public class RoomMoviePrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //генерация key
    Long id;

    @ManyToOne
    @JoinColumn(name = "price_id")
    Price price;

    @ManyToOne
    @JoinColumn(name = "room_movie_id")
    RoomMovie roomMovie;

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
