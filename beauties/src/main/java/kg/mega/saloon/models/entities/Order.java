package kg.mega.saloon.models.entities;

import kg.mega.saloon.enums.OrderStatusEnum;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //ключ будет генерироваться
    Long id;
    Date addDate;
    Date updateDate;
    Date appointment_date;
    boolean active;
    int confirmCode;

    @Enumerated(EnumType.STRING)
    OrderStatusEnum status;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

    @OneToOne
    @JoinColumn(name = "master_id")
    Master master;



    @PrePersist
    protected void onCreate() {
        addDate=new Date();
        status = OrderStatusEnum.SUSPEND;
        updateDate = new Date();
        active = true;
    }

    @PreUpdate
    protected void OnUpdate(){
        updateDate=new Date();
    }


}
