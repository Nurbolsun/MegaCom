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
@Table(name = "tb_seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int num;
    int row;
    Date addDate;
    Date updateDate;
    boolean active;
    @ManyToOne
    @JoinColumn(name = "tb_room")
    Room room;


    @PrePersist
    protected void onCreate() {
        active = true;
    }

}
