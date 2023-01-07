package kg.megacom.beauties.models.entities;

import kg.megacom.beauties.enums.OrderStatusEnum;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "tb_order")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Date addDate;
    Date updateDate;
    Date appointmantDate;

    @Enumerated(EnumType.STRING)
    OrderStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @ManyToOne
    @JoinColumn(name = "master_id")
    Master master;
}
