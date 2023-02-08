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
@Table(name = "tb_order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //генерация key
    Long id;
    @ManyToOne
    @JoinColumn(name = "seat_schedule_id")
    SeatSchedule seatSchedule;

    @ManyToOne
    @JoinColumn(name = "order_id")
    Order order;

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
