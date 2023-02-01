package kg.cinematica.models.entities;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import java.util.Date;

public class OrderDetail {

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
