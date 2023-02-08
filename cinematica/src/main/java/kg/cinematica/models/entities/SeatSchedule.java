package kg.cinematica.models.entities;

import kg.cinematica.enums.Status;
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
@Table(name = "tb_seat_schedule")
public class SeatSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    Seat seat;

    @ManyToOne
    @JoinColumn(name = "room_movie_id")
    RoomMovie roomMovie;

    @Enumerated(EnumType.STRING)
    Status status;

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
