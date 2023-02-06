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
@Table(name = "tb_order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //генерация key
    Long id;
    @ManyToOne
    @JoinColumn(name = "tb_seat_schedule")
    SeatSchedule seatSchedule;

    @ManyToOne
    @JoinColumn(name = "tb_order")
    Order order;

    Date addDate;
    Date updateDate;
    boolean active;

    @PrePersist
    protected void onCreate() {
        active = true;
    }
}
