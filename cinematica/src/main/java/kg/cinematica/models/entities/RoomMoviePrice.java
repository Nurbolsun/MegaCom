package kg.cinematica.models.entities;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
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
    @JoinColumn(name = "tb_price")
    Price price;

    @ManyToOne
    @JoinColumn(name = "tb_room_movie")
    RoomMovie roomMovie;

    Date addDate;
    Date updateDate;
    boolean active;

}
