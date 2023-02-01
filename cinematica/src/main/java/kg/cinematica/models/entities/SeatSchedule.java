package kg.cinematica.models.entities;

import kg.cinematica.enums.Status;
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
@Table(name = "tb_seat_schedule")
public class SeatSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "tb_seat")
    Seat seat;

    @ManyToOne
    @JoinColumn(name = "tb_room_movie")
    RoomMovie roomMovie;

    @Enumerated(EnumType.STRING)
    Status status;

    Date addDate;
    Date updateDate;
    boolean active;

    @PrePersist
    protected void onCreate() {
        active = true;
    }
}
